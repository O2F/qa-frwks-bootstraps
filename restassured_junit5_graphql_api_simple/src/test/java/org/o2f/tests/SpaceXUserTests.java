package org.o2f.tests;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.o2f.pojos.GraphQLQuery;
import org.o2f.pojos.variables.DeleteSpaceXUsernameByRocketPartialName;
import org.o2f.pojos.variables.UpdateSpaceXUserNameByID;
import org.o2f.pojos.variables.SpaceXUser;
import org.o2f.utils.MutationsPayload;
import org.o2f.utils.RequestSpec;

import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@Slf4j
public class SpaceXUserTests {

    @BeforeEach
    void Setup(){

        //This setup doesn't get the values from the configuration
        RestAssured.baseURI = "https://api.spacex.land/";

    }

    @Test
    @DisplayName("Test create user")
    public void testCreateUser(){

        SpaceXUser spaceXUser = SpaceXUser
                .builder()
                .id(UUID.randomUUID())
                .name(RandomStringUtils.random(10, true, false))
                .rocket(String.format("Inception Rocket Monster %s", RandomStringUtils.random(5, false, true)))
                .build();

        GraphQLQuery graphQLQuery = GraphQLQuery
                .builder()
                .query("mutation insert_users ($id: uuid!, $name: String!, $rocket: String!) { insert_users(objects: {id: $id, name: $name, rocket: $rocket}) { returning { id name rocket } } }")
                .variables(spaceXUser)
                .build();

        RequestSpec
                .query(graphQLQuery)
                .post()
                .then()
                .statusCode(200)
                .and()
                .body("data.insert_users.returning[0].id", equalTo(spaceXUser.getId().toString()))
                .body("data.insert_users.returning[0].name", equalTo(spaceXUser.getName()))
                .body("data.insert_users.returning[0].rocket", equalTo(spaceXUser.getRocket()))
                .log()
                .body();

    }

    @Test
    @DisplayName("Update SpaceX user by UUID")
    public void updateUserByUUID(){

        UUID uuid = UUID.randomUUID();

        SpaceXUser spaceXUser = SpaceXUser
                .builder()
                .id(uuid)
                .name(RandomStringUtils.random(10, true, false))
                .rocket(String.format("Inception Rocket Monster %s", RandomStringUtils.random(5, false, true)))
                .build();

        GraphQLQuery graphQLQuery = GraphQLQuery
                .builder()
                .query("mutation insert_users ($id: uuid!, $name: String!, $rocket: String!) { insert_users(objects: {id: $id, name: $name, rocket: $rocket}) { returning { id name rocket } } }")
                .variables(spaceXUser)
                .build();

        // create user
        RequestSpec
                .query(graphQLQuery)
                .post()
                .then()
                .statusCode(200)
                .log()
                .body();

        // new user name
        String newUserName = RandomStringUtils.random(10, true, false);

        // new query to update user name using the UUID
        String updateQuery = "mutation Mutation($where: users_bool_exp!, $set: users_set_input) { " +
                "  update_users(where: $where, _set: $set) { " +
                "    affected_rows " +
                "    returning { " +
                "      name " +
                "      id " +
                "      rocket " +
                "    } " +
                "  } " +
                "}";

        MutationsPayload mutationsPayload = new MutationsPayload();
        UpdateSpaceXUserNameByID updateVariables = mutationsPayload.updateUserNameByIDVariable(uuid.toString(),newUserName);

        // new graphQL payload
        GraphQLQuery updateGraphQLQuery = GraphQLQuery
                .builder()
                        .query(updateQuery)
                        .variables(updateVariables)
                .build();

        RequestSpec
                .query(updateGraphQLQuery)
                .post()
                .then()
                .statusCode(200)
                .body("data.update_users.returning[0].name", not(equalTo(spaceXUser.getName())))
                .body("data.update_users.affected_rows", equalTo(1))
                .body("data.update_users.returning[0].id", equalTo(uuid.toString()))
                .log()
                .body();

    }

    @AfterEach
    @DisplayName("Remove user by partial rocket name")
    void removeUser(){
        // THIS WOULD BE A NEW TEST BUT IT IS NOT TO CREATE TOO MUCH GARBAGE IN THE PUBLIC API
        // -- TEST DELETE USER BY UUID --

        /*
        Previous steps
        - create a new user saving the uuid
         */

        String deleteQuery = "mutation Mutation($where: users_bool_exp!) { " +
                "  delete_users(where: $where) { " +
                "    returning { " +
                "      id " +
                "      name " +
                "    } " +
                "  } " +
                "}";

        MutationsPayload secondMutationsPayload = new MutationsPayload();
        DeleteSpaceXUsernameByRocketPartialName deletePayload =
                secondMutationsPayload.deleteSpaceXUsernameByRocketPartialNameVariable("Inception Rocket Monster%");


        GraphQLQuery deleteGraphQLQuery = GraphQLQuery
                .builder()
                .query(deleteQuery)
                .variables(deletePayload)
                .build();

        RequestSpec
                .query(deleteGraphQLQuery)
                .post()
                .then()
                .statusCode(200)
                .log()
                .body();
    }
}
