Feature: consultar empleados

    Scenario: Visualizar número de empleados
        Given: un administrador
        And: quiere consultar empleados
        When: realiza petición de consulta (get)
        Then: devuelve json con lista empleados

    Scenario: consultar empleados lista vacía
        Given: un administrador
        And: quiere consultar empleados
    when: realiza petición de consulta
    but: la lista está vacía
    then: devuelve advertencia

    Scenario: visualizar determinado número de empleados
        Given: un administrador
        And: quiere consultar empleados
        And: conoce numero exacto empleados
        When: realiza petición de consulta
        Then: devuelve json con número exacto empleados

    Scenario: visualizar empleados sin archivo
        Given: un administrador
        And: quiere consultar empleados
        When: realiza petición de consulta
but: no existe el archivo
then: mostrar error de advertencia