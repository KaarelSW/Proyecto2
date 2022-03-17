Feature: Buscar datos detallados de un empleado

	Scenario: Al pedir los datos de un empleado, si el empleado se encuentra en la base de datos, se devuelve un ok
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		Then el empleado existe y se devuelve un ok

	Scenario: Se devuelve un error al pedir los datos de un empleado si este no existe
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		But  no encuentra el nombre de usuario del empleado
		Then devuelve un aviso de error
	
	Scenario: Al pedir los datos de un empleado, se devuelven todos los datos de ese empleado. 
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		Then devuelve un objeto cuyo numero de propiedades coincide con las de empleado

	Scenario: Da error si al pedir los datos de un empleado, el valor de alguna propiedad está vacio
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		And alguna de sus propiedades está vacia
		Then devuelve un error

	Scenario: Al pedir los datos de un empleado, la propiedad nombre es una cadena de caracteres alfabéticos
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		Then se devuelve un empleado cuyo propiedad nombre está compuesta por caracteres alfabeticos

	Scenario: Da error al pedir los datos de un empleado cuyo nombre no es valido
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		And el nombre no es un dato valido
		Then se devuelve un error

	Scenario: Al pedir los datos de un empleado, la propiedad apellido es una cadena de caracteres alfabéticos
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		Then se devuelve un empleado cuya propriedad apellido está compuesta por caracteres alfabeticos

	Scenario: Da error al pedir los datos de un empleado cuyo apellido no es valido
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		And el apellido no es un dato válido
		Then se devuelve un error

	Scenario: Al pedir los datos de un empleado, la propiedad email tiene un formato válido.
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		Then se devuelve un empleado cuya propriedad email tiene un formato correcto. 

	Scenario: Da error al pedir los datos de un empleado cuyo email no es valido
		Given un administrador quiere consultar un empleado
		When realiza petición de consulta por nombre de usuario
		And el email no tiene un formato válido
		Then se devuelve un error