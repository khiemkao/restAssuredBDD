package step_definitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import plain_Old_Java_Objects.Product_JO;
import utils.BaseAPI;
import utils.BaseVars;
import utils.Helps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class Products_steps {
    private BaseAPI baseAPI = new BaseAPI();
    private Product_JO productJO;
    private BaseVars baseVars = new BaseVars();
    private Helps helps = new Helps();


    @When("^I perform the products call with query params as \"(.*)\"$")
    public void iPerformTheProductionsCallWithQueryParams(String testData) {
        productJO = new Product_JO(helps.getJsonObjectFromFile(baseVars.testData_Products, testData));
        BaseVars.response = baseAPI.executeWithQueryParams(helps.convertObjectToMap(productJO));
    }

    @Then("I should see the product information of \"(.*)\"")
    public void iShouldSeeTheDetailInformation(String testData) {
        productJO = new Product_JO(helps.getJsonObjectFromFile(baseVars.testData_Products, testData));
        List<Product_JO> actual = BaseVars.response.getBody().jsonPath().getList("", Product_JO.class);
        assertThat(helps.compareObjects(actual.stream().findFirst().get(), productJO), Matchers.is(true));
    }
}
