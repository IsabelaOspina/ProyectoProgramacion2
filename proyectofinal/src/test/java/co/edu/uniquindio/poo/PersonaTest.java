package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    private static final Logger LOG = Logger.getLogger(Persona.class.getName());

    //prueba para crear una persona correctamente
    @Test
    public void TestConstructor() {
        LOG.info("iniciando prueba");
        String nombre = "Juan";
        String apellido = "Pérez";
        String telefono = "1234567890";
        int edad = 30;
        String id = "ID123";

        Persona persona = new Persona(nombre, apellido, telefono, edad, id);

        assertEquals(nombre, persona.getNombrePersona(), "El nombre no coincide");
        assertEquals(apellido, persona.getApellidopersona(), "El apellido no coincide");
        assertEquals(telefono, persona.getTelefonoPersona(), "El teléfono no coincide");
        assertEquals(edad, persona.getEdad(), "La edad no coincide");
        assertEquals(id, persona.getIdPersona(), "El ID no coincide");

        LOG.info("finalizando prueba");
    }


    //los datos no sean nulos
    @Test
    public void TestValoresNoNulos() {
        LOG.info("iniciando prueba");
        Persona persona = new Persona("Ana", "López", "0987654321", 25, "ID456");

        assertNotNull(persona.getNombrePersona(), "El nombre debería no ser nulo");
        assertNotNull(persona.getApellidopersona(), "El apellido debería no ser nulo");
        assertNotNull(persona.getTelefonoPersona(), "El teléfono debería no ser nulo");
        assertNotNull(persona.getIdPersona(), "El ID debería no ser nulo");

        LOG.info("finalizando pruebas");
    }

}
    

