package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RetrieveDiscountsStepDef {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_DISCOUNT_BY_UUID= "http://52.65.9.120:9999/rest/v1/users/qa-test-user/discounts";


	@Given("a customer exists and one or more discount objects have been set up in the system UUID (.*)")
	public void a_products_exists_for_UUID(String UUID){
		request = given().param("UUID", "UUID:" + UUID);
	}

	@When("a user retrieves the discount by valid UUID")
	public void a_discount_by_UUID(){
		response = request.when().get(ENDPOINT_GET_DISCOUNT_BY_UUID);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("the status in discounts is (\\d+)")
	public void verify_status_code_Product(int statusCode){
		json = response.then().statusCode(statusCode);
	}
	
	
}


