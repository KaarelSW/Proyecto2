package Proyecto2.pruebas;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class StepDefinitions {

	private static final String BASE_URL = "localhost:8080";
	RequestSpecification request;
    
    @Given("Dada la api")
    public void API_is_provided() throws Exception {
        RestAssured.baseURI  = BASE_URL;
        request = RestAssured.given();

    }
    Response response;
    @When("cuando se hace peticion GET '/get'")
    public void call_getAll_API() throws Exception {
    	response = request.get("/get");

    }

    @Then("status 200")
    public void a_status_200_() throws Exception {
    	Assert.assertEquals(response,"200");

    }

//    @Given("^Customer list API is provided$")
//    public void customer_list_API_is_provided() throws Exception {
//        prop.load(file);
//        RestAssured.baseURI  = prop.getProperty("baseUrl");
//        request = RestAssured.given();
//
//    }
//
//    @When("^User call customer list API$")
//    public void user_call_customer_list_API() throws Exception {
//        Header authorizationHeader = new Header("Authorization", prop.getProperty("token"));
//        request.header(authorizationHeader);
//        response = request.get("/customer/api/v1/list");
//    }
//
//    @Then("^Customer list will be shown$")
//    public void customer_list_will_be_shown() throws Exception {
//        System.out.println("Response Body is =>  " + response.asString());
//        String customerId=response.jsonPath().getString("Customers[0].id");
//        Assert.assertEquals(customerId,"101");
//
//    }
//
//    @Given("^Customer get API is provided$")
//    public void customer_get_API_is_provided() throws Exception {
//        prop.load(file);
//        RestAssured.baseURI  = prop.getProperty("baseUrl");
//        request = RestAssured.given();
//
//    }
//
//    @When("^User call customer get API$")
//    public void user_call_customer_get_API() throws Exception {
//        Header authorizationHeader = new Header("Authorization", prop.getProperty("token"));
//        request.header(authorizationHeader);
//        response = request.get("/customer/api/v1/get/101");
//
//    }
//
//    @Then("^Specific customer info will be shown$")
//    public void specific_customer_info_will_be_shown() throws Exception {
//        System.out.println("Response Body is =>  " + response.asString());
//        String customerId=response.jsonPath().getString("id");
//        Assert.assertEquals(customerId,"101");
//
//    }
}

