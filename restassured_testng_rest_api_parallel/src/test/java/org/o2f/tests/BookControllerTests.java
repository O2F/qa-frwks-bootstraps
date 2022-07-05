package org.o2f.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.o2f.TestLifeCycle;
import org.o2f.model.BookModel;
import org.o2f.utils.RequestSpec;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class BookControllerTests extends TestLifeCycle {

    @Test(testName = "Test Get all books - Full chained")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllBooksFullChainedTest() {

        log.debug(Thread.currentThread().getName());

        // Validation of a JSON Array item
        RequestSpec
                .bookRequestSpec()
                .get("/")
                .then()
                .statusCode(200)
                .body("title", hasItem("The book of testing"))
                .body("title", hasItems("Lets talk about testing", "The book of testing"))
                .log()
                .body()
                .log()
                .status();

    }

    @Test(testName = "Test Book detail is displayed when selected")
    @Severity(SeverityLevel.BLOCKER)
    void getBookDetailsTest(){
        log.debug(Thread.currentThread().getName());

        RequestSpec
                .bookRequestSpec()
                    .get("/1")
                .then()
                    .statusCode(200)
                .and()
                    .body("id",equalTo("1"))
                    .body("title", equalTo("The book of testing"))
                    .body("isbn", equalTo("123456789"))

                .log()
                .body();
    }

    @Test(testName = "Test not existing book" )
    void getNonExistingBookTest(){
        log.debug(Thread.currentThread().getName());

        BookModel bookModel = RequestSpec
                .bookRequestSpec()
                    .get("/1000000")
                .then()
                    .statusCode(404)
                .and()
                // Ways to validate empty body
                //All the body as an empty HashMap
                    .body(".",equalTo(new HashMap<String,String>() {}))
                //or each expected node as null
                    .body("id",equalTo(null))
                    .body("title",equalTo(null))
                    .body("isbn", equalTo(null))
                // or extract the body to a model and validate it after
                .extract()
                    .body()
                    .as(BookModel.class);

        assertThat(bookModel.getId(), equalTo(null));
        assertThat(bookModel.getTitle(), equalTo(null));
        assertThat(bookModel.getIsbn(), equalTo(null));
    }

    @Test(testName = "Test is possible to create a book")
    void createBookTest(){
        log.debug(Thread.currentThread().getName());

        BookModel book = BookModel
                .builder()
                .id("6")
                .title("Test this not that")
                .isbn("987654321")
                .build();

        RequestSpec
                .bookRequestSpec(book)
                    .post()
                .then()
                    .statusCode(201)
                .and()
                    .body("id", equalTo(book.getId()))
                    .body("title", equalTo(book.getTitle()))
                    .body("isbn", equalTo(book.getIsbn()));
    }

    @Test(testName = "Test is not possible to create twice the same book")
    void createBookTwiceTest() throws InterruptedException {
        log.debug(Thread.currentThread().getName());

        BookModel book = BookModel
                .builder()
                    .id("1000")
                    .title("Test the other way around")
                    .isbn("9876543210")
                .build();

        // Add the book the 1st time
        RequestSpec
                .bookRequestSpec(book)
                    .post()
                .then()
                    .statusCode(201);

        // Due to a docker refresh problem
        Thread.sleep(250);

        // Try to add the book the 2nd time
        RequestSpec
                .bookRequestSpec(book)
                    .post()
                .then()
                    .statusCode(500);
    }

    @Test(testName = "Test is possible to edit the same book")
    void editBookTest() throws InterruptedException {
        log.debug(Thread.currentThread().getName());

        BookModel book = BookModel
                .builder()
                .id("1001")
                .title("Don't test this way")
                .isbn("98765432100")
                .build();

        RequestSpec
                .bookRequestSpec(book)
                .post()
                .then()
                .statusCode(201);

        book.toBuilder()
                .title("Do tests as the book states")
                .build();

        // Due to a docker refresh problem
        Thread.sleep(250);

        RequestSpec
                .bookRequestSpec(book)
                .put(String.format("/%s", book.getId()))
                .then()
                .statusCode(200)
                .body("title", equalTo(book.getTitle()));
    }
}
