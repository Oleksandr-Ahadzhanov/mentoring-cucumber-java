package API;

import apiModel.MultipleUserModel;
import apiModel.SingleUserModel;
import io.restassured.response.Response;

import static API.ScenarioContext.ContextEnum.HTTP_RESPONSE;
import static API.ScenarioContext.getContext;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RestAssuredAssertions {

    public static void checkIfResponseStatusCodeIs200() {
        Response response = getContext(HTTP_RESPONSE);
        response
                .then()
                .statusCode(200);
    }

    public static void checkIfResponseBodyIsEqualToTestDataFile() {
        Response response = getContext(HTTP_RESPONSE);
        String respBodyAsString = response.getBody().asString();
        assertThat(respBodyAsString, matchesJsonSchemaInClasspath("user.json"));
    }

    public static void checkIfResponseDataIsEqualToTestDefinition() {
        Response response = getContext(HTTP_RESPONSE);
        SingleUserModel getResp = response.getBody().as(SingleUserModel.class);
        assertThat(getResp.getData().getFirst_name(), equalTo("Janet"));
    }

    public static void checkIfResponseBodyIsEqualToMultiplyUserTestDataFile() {
        Response response = getContext(HTTP_RESPONSE);
        String respBodyAsString = response.getBody().asString();
        assertThat(respBodyAsString, matchesJsonSchemaInClasspath("listOfUsers.json"));
    }

    public static void checkIfResponseDataIsEqualToMultiplyUserTestDefinition() {
        Response response = getContext(HTTP_RESPONSE);
        MultipleUserModel getResp = response.getBody().as(MultipleUserModel.class);
        assertThat(getResp.getData().get(1).getEmail(), equalTo("lindsay.ferguson@reqres.in"));
    }
}
