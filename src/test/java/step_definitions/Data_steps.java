package step_definitions;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import plain_Old_Java_Objects.Data_JO;
import utils.BaseAPI;
import utils.BaseVars;
import utils.Helps;

public class Data_steps {
    private BaseAPI baseAPI = new BaseAPI();
    private Data_JO dataJO;
    private BaseVars baseVars = new BaseVars();
    private Helps helps = new Helps();

    @When("^I perform the data call with query params as \"(.*)\"$")
    public void iPerformTheDataCallWithQueryParams(String testData) {
        dataJO = new Data_JO(helps.getJsonObjectFromFile(baseVars.testData_Data, testData));
        BaseVars.response = baseAPI.executeWithBody(helps.convertObjectToMap(dataJO));
    }

    @Then("^I should see the responseBody of Data$")
    public void iShouldSeeTheResponseBodyOfData() {
        BaseVars.response.getBody().print();
    }
}
