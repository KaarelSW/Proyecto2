package Proyecto2.cucumber;

import io.cucumber.java.BeforeAll;
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.junit.Assert;

public class StepDefinitions {
	
	RequestSpecification request;
	static String url;
	
	@BeforeAll
	public static void Before_All() {
		Properties props = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("url.properties");
            props.load(in);
            //System.out.println(props.getProperty("baseUrl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                 if (in != null) {
                     in.close();
                 }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        url = props.getProperty("baseUrl");
	}
		
        
    
    
	//Feature: Consultar todos los empleados
    
    @Given("^un administrador quiere consultar empleados$")
    public void ruta_de_API() throws Exception {
        RestAssured.baseURI  = url;
        request = RestAssured.given();

    }
    
    Response response;
    @When("realiza petición de consulta")
    public void call_getAll_API() throws Exception {
    	response = request.get("/empleados");

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
        RestAssured.baseURI  = url;
        request = RestAssured.given();

    }
    
    @When("realiza petición de consulta por nombre de usuario")
    public void call_getEmpleado_API() throws Exception {
    	String usuarioEmpleado = "jeserodriguez93";
    	response = request.get("/empleado/"+usuarioEmpleado);

    }
    
    @Then("^el empleado existe y se devuelve un ok$")
    public void status_200() throws Exception {
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(200,statusCode);

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
    
    
    int nombreLenght, apellidoLenght, correoLenght, usuarioLenght, direccionLenght, contrasenyaLenght;
    @And("^alguna de sus propiedades está vacia$")
    public void alguna_de_sus_propiedad_está_vacia() throws Exception {
    	JSONObject json = new JSONObject(response.body().asString());
    	nombreLenght = json.get("nombre").toString().length();
    	apellidoLenght = json.get("apellido").toString().length();
    	correoLenght = json.get("correo").toString().length();
    	usuarioLenght = json.get("usuario").toString().length();
    	direccionLenght = 0;
    	contrasenyaLenght = json.get("contraseña").toString().length();
    }
    
    @Then("^devuelve un error al respecto$")
    public void devuelve_un_error_al_respecto() throws Exception {
    	int sumaLenght =nombreLenght + apellidoLenght + correoLenght + usuarioLenght + direccionLenght + contrasenyaLenght;
    	Assert.assertTrue(nombreLenght == 0 || apellidoLenght == 0 || correoLenght == 0 || usuarioLenght == 0 || direccionLenght == 0 || contrasenyaLenght == 0);

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


