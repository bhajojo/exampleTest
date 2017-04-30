package stepdefs;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PurchaseProductFailedStepDef {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_PURCHASE_PRODUCT_BY_UUID= "http://52.65.9.120:9999/rest/v1/users/qa-test-user/products/sku-555555555/discounts/20-percent-off";

	@Given("a customer exists with an UUID(.*)")
	public void a_Customer_exists(String UUID){
		request = given().param("UUID", "UUID:" + UUID);
	}

	@When("Purchase Product API is called with a valid customer UUID (.*) with productId (.*) with discount(.*)")
	public void Purchase_product_with_valid_customer(String UUID,String productId, String discount){
		response = request.when().post(ENDPOINT_PURCHASE_PRODUCT_BY_UUID);
		System.out.println("response: " + response.prettyPrint());
	}

	@Then("the status in failed is (\\d+)")
	public void verify_status_code_Invalid(int statusCode){
		json = response.then().statusCode(statusCode);
	}
}
