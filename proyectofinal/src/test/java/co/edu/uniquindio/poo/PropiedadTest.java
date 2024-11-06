package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.Observer.Observador;

public class PropiedadTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testAgrearPropiedadValida() {
        LOG.info("Iniciación test CrearPropiedadValida");

        Propietario propietario = new Propietario("Juan", "Pérez", "123456789", 30, "ID001", new ArrayList<>());
        Propiedad propiedad = new Casa("sur", "Casa basica", "Mz_A Cs_03", 200000, 10000, propietario, false, 40000);

        assertEquals("sur", propiedad.getLocalizacion());
        assertEquals("Casa basica", propiedad.getDescripcionPropiedad());
        assertEquals("Mz_A Cs_03", propiedad.getIdPropiedad());
        assertEquals(200000, propiedad.getValorArriendo());
        assertEquals(10000, propiedad.getValorDeposito());
        assertEquals(propietario, propiedad.getPropietario());
        assertEquals(40000, propiedad.getComision());
        assertFalse(propiedad.isEstaArrendada());

        LOG.info("Finalización test CrearPropiedadValida");
    }

    @Test
    public void testCambiarEstadoPropiedad() {
        LOG.info("Iniciación test CambiarEstadoPropiedad");

        Propietario propietario = new Propietario("José", "Gomez", "3123456789", 33, "4589632", new ArrayList<>());
        Propiedad propiedad = new Casa("sur", "Casa basica", "ID002", 200000, 10000, propietario, false, 40000);

        propiedad.setEstaArrendada(true);
        assertTrue(propiedad.isEstaArrendada(), "La propiedad esta arrendada");
        propiedad.setEstaArrendada(false);
        assertFalse(propiedad.isEstaArrendada(), "La propiedad esta disponible");

        LOG.info("Finalización test CambiarEstadoPropiedad");
    }

    @Test
    public void testAgregarObservador() {
        LOG.info("Iniciación test AgregarObservador");

        Propietario propietario = new Propietario("Juan", "Pérez", "3123456789", 30, "55632555", new ArrayList<>());
        Propiedad propiedad = new Local("norte", "Local basico ", "plazaFlora Local 2", 3000000, 150000,propietario, false, 70000);

        // Usamos una clase anónima para implementar la interfaz Observador
        Observador observador = new Observador() {
            @Override
            public void notificarEstado(Propiedad propiedad) {
            }
        };
        propiedad.agregarObservadores(observador);

        assertTrue(propiedad.getObservadores().contains(observador), "El observador debería estar en la lista");

        LOG.info("Finalización test AgregarObservador");
    }

    @Test
    public void testEliminarObservador() {
        LOG.info("Iniciación test EliminarObservador");

        Propietario propietario = new Propietario("Juan", "Pérez", "3123456789", 30, "45986300", new ArrayList<>());
        Propiedad propiedad = new Local("norte", "Local basico ", "plazaFlora Local 2", 3000000, 150000,
                propietario, false, 70000);

        // Usamos una clase anónima para implementar la interfaz Observador
        Observador observador = new Observador() {
            @Override
            public void notificarEstado(Propiedad propiedad) {
            }
        };
        propiedad.agregarObservadores(observador);
        assertTrue(propiedad.getObservadores().contains(observador), "El observador esta en la lista");

        propiedad.eliminarObservadores(observador);
        assertFalse(propiedad.getObservadores().contains(observador), "El observador no esta en la lista");

        LOG.info("Finalización test EliminarObservador");
    }

}
