package stepdefs;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PurchaseProductStepDef {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_PURCHASE_PRODUCT_BY_UUID= "http://52.65.9.120:9999/rest/v1/users/qa-test-user/products/sku-1234567890/discounts/50-percent-off";


	@Given("a customer exists with UUID(.*)and has at least one discount that can be used with productId(.*)")
	public void a_discount_exists_for_ProductID(String UUID, String productId, String discount){
		request = given().param("SKU", "SKU:" + productId);
	}

	@When("user retrieves UUID(.*) their eligible discountId(.*)")
	public void user_retrieves_eligible_discounts(String UUID,String discountId){
		response = request.when().post(ENDPOINT_PURCHASE_PRODUCT_BY_UUID);
		System.out.println("response: " + response.prettyPrint());
	}

	@And("they have chosen a discountId (.*) that is valid for product (.*)")
	public void Chosen_a_discount_with_product(String ProductCode,String discountId){
		json = response.then().statusLine("ProductCode");
	}
	
	@Then("the status in products is (\\d+)")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
		System.out.println(json);
	}

}
