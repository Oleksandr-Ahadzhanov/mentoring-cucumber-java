# Automation test framework

**BDD automation test framework**  - User Login and Add product to Shopping Cart features are covered by automation scripts.

Table of contents
=================
   * [Key features](#key-features)
   * [Technologies and frameworks](#technologies-and-frameworks)
   * [Test scenario example](#test-scenario-example)
   * [Test step example](#test-step-example)   
   * [Test runner](#test-runner)
   * [Run options](#run-options)
   * [Report](#report)

## Key features
  * BDD (Cucumber framework) is used for readability and extensibility of tests

    
## Technologies and frameworks
 * Java programming language ([Java](https://www.java.com)) 
 * Cucumber BDD framework ([Cucumber](https://cucumber.io/docs))
 * Maven build tool ([Maven](https://maven.apache.org))

## Test scenario example

```java
  Scenario: Demonstrating that user is able to sign in into the App
      Given I am on the Home page
      When I do sign in
      Then I am signed in user
```

## Test step example

```java
     @When("^I do sign in$")
         public void sign_in_into_the_app() {
             homePage.signInIntoTheApp();
         }
```

## Test runner

```java
@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        glue = {"stepdefs"}
)
```

## Run options
 * Locally via IDE (To run separate scenario you need Cucumber Java plugin to be installed)
 * Maven (possible to run tests by 'mvn clean test' command in Windows cmd).

## Report
 * Report is located in target/allure-results