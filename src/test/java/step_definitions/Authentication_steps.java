package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import plain_Old_Java_Objects.Authentication_JO;
import utils.BaseAPI;
import utils.BaseVars;
import utils.JsonReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Authentication_steps {
    private BaseAPI baseAPI = new BaseAPI();
    private Authentication_JO authenJO;
    private String testUserFile = "./src/test/java/data/Authentication.json";

    @Given("^I prepare the \"(.*)\" request with path \"(.*)\"$")
    public void iPrepareThePostRequestWithPath(String method, String path) {
        BaseVars.request = baseAPI.setRequest(method, path);
    }

    @When("^I perform the login call with \"(.*)\"$")
    public void iPerformTheLoginCallWithUser(String testUser) {
        authenJO = new Authentication_JO(JsonReader.getJsonObjectFromFile(testUserFile, testUser));
        BaseVars.response = baseAPI.executeWithBody(authenJO);
    }

    @Then("^I should see the \"(.*)\" status code$")
    public void iShouldSeeTheStatusCode(int code) {
        assertThat(BaseVars.response.getStatusCode(), is(code));
    }

    @Then("^I should see the access token$")
    public void iShouldSeeTheAccessToken() {
        assertThat(BaseVars.response.getBody().jsonPath().get("access_token"), notNullValue());
    }

    @Then("^I should see the error message as \"(.*)\"$")
    public void iShouldSeeTheErrorMessage(String message) {
        assertThat(BaseVars.response.getBody().jsonPath().get("message"), equalTo(message));
    }
}
