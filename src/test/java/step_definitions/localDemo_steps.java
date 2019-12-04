package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.BaseAPI;
import utils.BaseVars;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class localDemo_steps {
    protected BaseAPI baseAPI = new BaseAPI();

    @Given("^I prepare the (.*) request with path \"(.*)\"$")
    public void iPrepareThePostRequestWithPath(String method, String path) {
        BaseVars.request = baseAPI.prepareHeader(method, path);
    }

    @When("^I perform the call with path params \"(.*)\"$")
    public void iPerformTheCallWithPathParams(String id) {
        BaseVars.response = baseAPI.executeWithPathParams(id);
    }

    @Then("^I should see the \"(.*)\" status code$")
    public void iShouldSeeTheStatusCode(int code) {
        assertThat(BaseVars.response.getStatusCode(), is(code));
    }
}
