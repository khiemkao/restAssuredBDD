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

    @Given("^I prepare the \"(.*)\" request with path \"(.*)\"$")
    public void iPrepareThePostRequestWithPath(String method, String path) {
        BaseVars.request = baseAPI.prepareRequest(method, path);
    }

    @When("^I perform the call with query \"(.*)\" value \"(.*)\"$")
    public void iPerformTheCallWithQuery(String id, String value) {
        Map<String, String> query = new HashMap<>();
        query.put(id, value);
        BaseVars.response = baseAPI.executeWithQueryParams(query);
    }

    @Then("^I should see the \"(.*)\" status code$")
    public void iShouldSeeTheStatusCode(int code) {
        BaseVars.response.getBody().print();
        assertThat(BaseVars.response.getStatusCode(), is(code));
    }
}
