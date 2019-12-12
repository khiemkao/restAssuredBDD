package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import plain_Old_Java_Objects.Stores_JO;
import utils.BaseAPI;
import utils.BaseVars;
import utils.Helps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class Stores_steps {
    private Stores_JO storesJO;
    private Helps helps = new Helps();
    private BaseVars baseVars = new BaseVars();
    private BaseAPI baseAPI = new BaseAPI();

    @When("^I perform the stores call with body as \"(.*)\"$")
    public void iPerformTheStoresCallWithBody(String testData) {
        storesJO = new Stores_JO(helps.getJsonObjectFromFile(baseVars.testData_Stores, testData));
        BaseVars.response = baseAPI.executeWithBody(storesJO);
    }

    @When("^I perform the stores call with query params as \"(.*)\"$")
    public void iPerformTheStoresCallWithQueryParams(String testData) {
        storesJO = new Stores_JO(helps.getJsonObjectFromFile(baseVars.testData_Stores, testData));
        BaseVars.response = baseAPI.executeWithQueryParams(helps.convertObjectToMap(storesJO));
    }

    @Then("^I should see the id property returning with value$")
    public void iShouldSeeTheIdPropertyReturningWithValue() {
        assertThat(BaseVars.response.getBody().jsonPath().get("id"), notNullValue());
    }

    @Then("^I should see the store information of \"(.*)\"$")
    public void iShouldSeeTheStoreInformation(String testData) {
        storesJO = new Stores_JO(helps.getJsonObjectFromFile(baseVars.testData_Stores, testData));
        List<Stores_JO> actual = BaseVars.response.getBody().jsonPath().getList("", Stores_JO.class);
        assertThat(helps.compareObjects(actual.stream().findFirst().get(), storesJO), Matchers.is(true));
    }
}
