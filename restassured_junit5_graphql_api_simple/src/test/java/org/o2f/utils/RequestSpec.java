package org.o2f.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.o2f.pojos.GraphQLQuery;

import static io.restassured.RestAssured.given;

public final class RequestSpec {

    private RequestSpec(){}

    public static RequestSpecification query(GraphQLQuery qlQuery){
        RestAssured.basePath = "/graphql";

        return given()
                .contentType(ContentType.JSON)
                .body(qlQuery)
                .when();
    }


}
