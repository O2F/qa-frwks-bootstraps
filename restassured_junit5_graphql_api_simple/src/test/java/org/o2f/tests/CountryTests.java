package org.o2f.tests;

import lombok.extern.slf4j.Slf4j;
import org.CommonTestLifeCycle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.o2f.pojos.GraphQLQuery;
import org.o2f.pojos.variables.CountryIsoCode2;
import org.o2f.utils.RequestSpec;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

@Slf4j
public class CountryTests extends CommonTestLifeCycle {

    @Test
    @DisplayName("Test query country full data")
    public void testQueryCountryFullData(){

        GraphQLQuery gqlQuery = GraphQLQuery.builder()
                .query("query getCountryData($code: ID!) { country(code: $code) { name native capital emoji currency languages { code name } } }")
                .build();

        gqlQuery = gqlQuery.toBuilder().variables(new CountryIsoCode2("PT")).build();

        RequestSpec
                .query(gqlQuery)
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .body("data.country.name", equalTo("Portugal"))
                .body("data.country.languages[0].name", equalTo("Portuguese"))
                .log()
                .body();
    }

    @Test
    @DisplayName("Test Query all countries")
    public void testQueryAllCountries() throws InterruptedException {

        GraphQLQuery qlQuery = GraphQLQuery
                .builder()
                .query("query getAllCountries { countries { code name phone } }")
                .build();

        RequestSpec
                .query(qlQuery)
                .post()
                .then()
                .statusCode(200)
                .body("data.countries.code", hasItem("PT"))
                .body("data.countries.name", hasItem("Portugal"))
                .body("data.countries.phone", hasItem("351"));

    }

}
