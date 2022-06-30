package org.o2f.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.o2f.CommonTestLifeCycle;
import org.o2f.model.BookModel;
import org.o2f.utils.RequestSpec;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Slf4j
public class SecondBookControllerTests extends CommonTestLifeCycle {

    //Same tests but to create the class parallelization

    @Test
    @DisplayName("Test Get all books - Full chained")
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

    @Test
    @DisplayName("Test Book detail is displayed when selected")
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

    @Test
    @DisplayName("Test Get all books - Full chained")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllBooksFullChainedTest1() {
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

    @Test
    @DisplayName("Test Book detail is displayed when selected")
    @Severity(SeverityLevel.BLOCKER)
    void getBookDetailsTest1(){
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
}
