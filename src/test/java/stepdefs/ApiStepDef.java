package stepdefs;

import API.RestAssuredAssertions;
import API.RestAssuredMain;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiStepDef {

//    @Given("Step from {string} in {string} feature file")
//    public void step(String scenario, String file) {
//        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
//                Thread.currentThread().getId(), scenario,file);
//    }

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
        RestAssuredAssertions.checkIfResponseDataIsEqualToTestDefinition();
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

    @When("^User sends POST request to /api/users with body post.json$")
    public void send_POST_request_to_the_api() {
        RestAssuredMain.postRequest("/api/users","src/test/resources/post.json");
    }
    @Then("^Status Code is 201$")
    public void check_if_status_code_is_201(){
        RestAssuredAssertions.checkIfResponseStatusCodeIs201();
    }
}
