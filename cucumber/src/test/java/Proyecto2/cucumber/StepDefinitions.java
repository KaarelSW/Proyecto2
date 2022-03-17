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
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.junit.Assert;

public class StepDefinitions {

    private static final int PORT = 8080;
    RequestSpecification request;

    // Feature: Consultar todos los empleados

    @Given("^un administrador quiere consultar empleados$")
    public void ruta_de_API() throws Exception {
        RestAssured.port = PORT;
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
        Assert.assertEquals(200, statusCode);
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

    // Feature: Buscar datos detallados de un empleado

    @Given("un administrador quiere consultar un empleado$")
    public void ruta_de_API2() throws Exception {
        RestAssured.port = PORT;
        request = RestAssured.given();

    }

    @When("realiza petición de consulta por nombre de usuario")
    public void call_getEmpleado_API() throws Exception {
    	String usuarioEmpleado = "jeserodiguez93";
    	response = request.get("/empleado/"+usuarioEmpleado);

    }

    @Then("^el empleado existe y se devuelve un ok$")
    public void status_200() throws Exception {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);

    }
    
    @But("no encuentra el nombre de usuario del empleado")
    public void no_encuentra_el_nombre_de_usuario_del_empleado() throws Exception {
    	String usuarioEmpleado = "cristianoRonaldoSiuuuU";
    	response = request.get("/empleado/" + usuarioEmpleado);
    }
    
    @Then("^devuelve un aviso de error$")
    public void devuelve_un_aviso_de_error() throws Exception {
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(404,statusCode);

    } 
    
    

    
    @Then("^devuelve un objeto cuyo numero de propiedades coincide con las de empleado$")
    public void devuelve_un_objeto_cuyo_numero_de_propiedades_coincide_con_las_de_empleado() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	Assert.assertTrue(json.length() == 6);
    }
    
    
    
    @Then("^se devuelve un empleado cuyo propiedad nombre está compuesta por caracteres alfabeticos$")
    public void se_devuelve_un_empleado_cuya_propriedad_nombre_esta_compuesta_por_caracteres_alfabeticos() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String nombre = json.get("nombre").toString();
    	Assert.assertTrue(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", nombre));
    	
    }
    
    
    
    String nombre;
    @And("^el nombre no es un dato valido$")
    public void el_nombre_no_es_un_dato_valido() throws Exception {
    	nombre = "vegetta777";
    }
    
    @Then("^se devuelve un error de nombre$")
    public void nombre_no_valido() throws Exception {
    	Assert.assertFalse(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", nombre));
    	
    }

    

    
    @Then("^se devuelve un empleado cuya propriedad apellido está compuesta por caracteres alfabeticos$")
    public void se_devuelve_un_empleado_cuya_propriedad_apellido_esta_compuesta_por_caracteres_alfabeticos() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String apellido = json.get("apellido").toString();
    	Assert.assertTrue(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", apellido));
    	
    }
    
    
    String apellido;
    @And("^el apellido no es un dato válido$")
    public void el_apellido_no_es_un_dato_valido() throws Exception {
    	apellido = "vegetta777";
    }
    
    @Then("^se devuelve un error de apellido$")
    public void apellido_no_valido() throws Exception {
    	Assert.assertFalse(Pattern.matches("^[a-zA-ZáéíóúÁÉÍÓÚ]*$", apellido));
    	
    }
    
    
    
    @Then("^se devuelve un empleado cuya propriedad correo tiene un formato correcto$")
    public void email_valido() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	String correo = json.get("correo").toString();
    	Assert.assertTrue(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", correo));
    	
    }
    
    
   
    String correo;
    @And("^el correo no tiene un formato válido$")
    public void correo_no_valido() throws Exception {
    	correo = "vegetta777@juanitooo.A";
    }
    
    @Then("^se devuelve un error de correo no valido$")
    public void email_no_valido() throws Exception {
    	Assert.assertFalse(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", correo));
    	
    }
    
    
}

    // Scenario: Da error si al pedir los datos de un empleado, el valor de alguna
    // propiedad está vacio
    int propiedadCodeExpected;

    @But("algunas de sus propiedades están vacías")
    public void alguna_propiedad_vacia() throws Exception {
        propiedadCodeExpected = 0;
    }

    @Then("^devuelve un error$")
    public void devolver_error_con_propiedad_vacia() throws Exception {

    }
}
