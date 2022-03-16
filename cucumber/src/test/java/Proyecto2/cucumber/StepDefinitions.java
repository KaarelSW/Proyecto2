package Proyecto2.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Assert;

public class StepDefinitions {

	private static final String BASE_URL = "localhost:8080";
	RequestSpecification request;
    
    @Given("^un administrador quiere consultar empleados$")
    public void API_is_provided() throws Exception {
        RestAssured.baseURI  = BASE_URL;
        request = RestAssured.given();

    }
    Response response;
    @When("realiza petición de consulta \\(get)")
    public void call_getAll_API() throws Exception {
    	response = request.get("/get");

    }

    @Then("^devuelve json con lista empleados$")
    public void a_status_200_() throws Exception {
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode,"200");

    }
}
