package org.o2f.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.o2f.TestLifeCycle;
import org.o2f.utils.RequestSpec;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

@Slf4j
public class SecondBookControllerTests extends TestLifeCycle {

    //Same tests but to create the class parallelization

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
}
