package stepdefs;

import API.RestAssuredAssertions;
import API.RestAssuredMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiStepDef {

    @Given("^User sets the link and contentType for request$")
    public void the_link_and_contextType_are_ready() {
        RestAssuredMain.setupRequestSpecification("https://reqres.in", "json");
    }
    @When("^User sends the request to the api$")
    public void send_request_to_the_api() {
        RestAssuredMain.getRequest("/api/users/2");
    }
    @Then("^Status Code is 200$")
    public void check_status_code() {
        RestAssuredAssertions.checkIfResponseStatusCodeIs200();
    }
    @And("^Response body is equal to test.json$")
    public void check_response_body(){
        RestAssuredAssertions.checkIfResponseBodyIsEqualToTestDataFile();
    }
    @And("^Response body contains FIRST_NAME filed with JANET value$")
    public void check_matches_of_values(){
        RestAssuredAssertions.checkIfResponseDataIsEqualToMultiplyUserTestDefinition();
    }

    @When("^User sends GET request to /api/users/page=2 api$")
    public void send_new_request_to_the_api() {
        RestAssuredMain.getRequest("/api/users?page=2");
    }

    @And("^Response body is equal to listOfUsers.json$")
    public void check_multiply_user_response_body(){
        RestAssuredAssertions.checkIfResponseBodyIsEqualToMultiplyUserTestDataFile();
    }

    @And("^Response body contains data-1.email filed with lindsay.ferguson@reqres.in value$")
    public void check_matches_of_values_for_multiply_users(){
        RestAssuredAssertions.checkIfResponseDataIsEqualToMultiplyUserTestDefinition();
    }
}
