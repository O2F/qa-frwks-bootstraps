package org.o2f.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.o2f.model.BookModel;

import static io.restassured.RestAssured.given;

public final class RequestSpec {

    private RequestSpec(){}

    public static RequestSpecification bookRequestSpec(){
        RestAssured.basePath = "/books";

        return given().when();
    }

    public static RequestSpecification bookRequestSpec(BookModel bookModel){
        RestAssured.basePath = "/books";

        return given()
                .contentType("application/json; charset=UTF-16")
                .body(bookModel)
                .when();
    }

}
