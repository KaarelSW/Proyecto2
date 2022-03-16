Feature: consultar empleados

    Scenario: Visualizar número de empleados
        Given: un administrador quiere consultar empleados
        When: realiza petición de consulta (get)
        Then: devuelve json con lista empleados

    Scenario: consultar empleados lista vacía
        Given: un administrador quiere consultar empleados
    		When: realiza petición de consulta
    		But: la lista está vacía
    		Then: devuelve advertencia

    Scenario: visualizar determinado número de empleados
        Given: un administrador quiere consultar empleados
        And: conoce numero exacto empleados
        When: realiza petición de consulta
        Then: devuelve json con número exacto empleados

    Scenario: visualizar empleados sin archivo
        Given: un administrador quiere consultar empleados
        When: realiza petición de consulta
				But: no existe el archivo
				Then: mostrar error de advertencia