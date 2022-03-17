package Proyecto2.cucumber;

import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.json.JSONObject;
import org.junit.Assert;

public class StepDefinitions {

	private static final int PORT = 8080;
	RequestSpecification request;
	
	//Feature: Consultar todos los empleados
    
    @Given("^un administrador quiere consultar empleados$")
    public void ruta_de_API() throws Exception {
        RestAssured.port  = PORT;
        request = RestAssured.given();

    }
    
    Response response;
    @When("realiza petición de consulta")
    public void call_getAll_API() throws Exception {
    	response = request.get("/get");

    }

    @Then("^devuelve un json$")
    public void status_200_y_body_tipo_json() throws Exception {
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(200,statusCode);
    	JSONObject json = new JSONObject(response.body().asString());
    	assertTrue(json instanceof JSONObject);

    }

    int lengthExpected;
    
    @But("^la lista está vacía$")
    public void la_lista_está_vacía() throws Exception {
    	lengthExpected = 0;
    	
    }

    @Then("^devuelve advertencia$")
    public void devuelve_advertencia() throws Exception {
    int responseLenght = response.body().toString().length();
    Assert.assertEquals(lengthExpected, responseLenght);

    }
    
    
    int itemsExpected;
    
    @And("conoce numero exacto empleados") 
    public void la_lista_tiene_10_empleados() throws Exception {
    	itemsExpected = 10;
    	
    }
    
    @Then("devuelve json con número exacto empleados")
    public void devuelve_json_10_items() throws Exception {
        List<E> listaEmpleados = response.body().jsonPath().getList("empleados");
        Assert.assertEquals(itemsExpected, listaEmpleados.size());
        
    }
    
    int statusCodeExpected;
    
    @But("^no existe el archivo$")
    public void no_existe_el_archivo() throws Exception {
    	statusCodeExpected = 404;
    	
    }

    @Then("^mostrar error de advertencia$")
    public void mostrar_error_de_advertencia() throws Exception {
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCodeExpected, statusCode);
    
    }
    
    //Feature: Buscar datos detallados de un empleado
    
    @Given("un administrador quiere consultar un empleado$")
    public void ruta_de_API2() throws Exception {
        RestAssured.port  = PORT;
        request = RestAssured.given();

    }
    
    @When("realiza petición de consulta por nombre de usuario")
    public void call_getEmpleado_API() throws Exception {
    	String usuarioEmpleado = "jeserodiguez93";
    	response = request.get("/get/"+usuarioEmpleado);

    }
    
    @Then("^devuelve un json$")
    public void status_200() throws Exception {
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(200,statusCode);

    }
}


