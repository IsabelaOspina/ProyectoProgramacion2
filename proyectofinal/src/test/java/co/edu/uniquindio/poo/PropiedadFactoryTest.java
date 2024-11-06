package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Factory.PropiedadFactory;

public class PropiedadFactoryTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testCrearApartamento() {
        LOG.info("Iniciación test CrearApartamento");

        Propietario propietario = new Propietario("Juan", "Lopez", "3123456789", 30, "12365489", new ArrayList<>());
        PropiedadFactory factory = new PropiedadFactory();
        Propiedad propiedad = factory.crearPropiedad("apartamento", "norte", "apartamento basico", "torre 6", 500000, 50000, propietario, false, 40000);

        assertTrue(propiedad instanceof Apartamento);
        assertEquals("norte", propiedad.getLocalizacion());
        assertEquals("apartamento basico", propiedad.getDescripcion());
        assertEquals("torre 6", propiedad.getIdPropiedad());
        assertEquals(500000, propiedad.getValorArriendo());
        assertEquals(50000, propiedad.getValorDeposito());
        assertEquals(40000, propiedad.getComision());

        LOG.info("Finalización test CrearApartamento");
    }

    @Test
    public void testCrearCasa() {
        LOG.info("Iniciación test CrearCasa");

        Propietario propietario = new Propietario("Juan", "Lopez", "3123456789", 40, "12365489", new ArrayList<>());
        PropiedadFactory factory = new PropiedadFactory();
        Propiedad propiedad = factory.crearPropiedad("casa", "sur", "casa basica", "belencito", 400000, 50000, propietario, false, 30000);

        assertTrue(propiedad instanceof Casa);
        assertEquals("sur", propiedad.getLocalizacion());
        assertEquals("casa basica", propiedad.getDescripcion());
        assertEquals("belencito", propiedad.getIdPropiedad());
        assertEquals(400000, propiedad.getValorArriendo());
        assertEquals(50000, propiedad.getValorDeposito());
        assertEquals(30000, propiedad.getComision());

        LOG.info("Finalización test CrearCasa");
    }

    @Test
    public void testCrearLocal() {
        LOG.info("Iniciación test CrearLocal");

        Propietario propietario = new Propietario("Maria", "Suarez", "3123456789", 33, "12365489", new ArrayList<>());
        PropiedadFactory factory = new PropiedadFactory();
        Propiedad propiedad = factory.crearPropiedad("local", "norte", "local basico ", "local 4", 4000000, 90000, propietario, false, 100000);

        assertTrue(propiedad instanceof Local);
        assertEquals("norte", propiedad.getLocalizacion());
        assertEquals("local basico ", propiedad.getDescripcion());
        assertEquals("local 4", propiedad.getIdPropiedad());
        assertEquals(4000000, propiedad.getValorArriendo());
        assertEquals(90000, propiedad.getValorDeposito());
        assertEquals(100000, propiedad.getComision());
        LOG.info("Finalización test CrearLocal");
    }

    @Test
    public void testCrearPropiedadConTipoIncorrecto() {
        LOG.info("Iniciación test CrearPropiedadConTipoIncorrecto");
  
        Propietario propietario = new Propietario("Luis", "Martínez", "987654324", 50, "1321456987", new ArrayList<>());
        PropiedadFactory factory = new PropiedadFactory();

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            factory.crearPropiedad("garaje", "oeste", "Garaje en la zona oeste", "garaje 03", 80000, 30000, propietario, false, 15000);
        });

        assertEquals("la propiedad no es compatible", thrown.getMessage());

        LOG.info("Finalización test CrearPropiedadConTipoIncorrecto");
    }
}
