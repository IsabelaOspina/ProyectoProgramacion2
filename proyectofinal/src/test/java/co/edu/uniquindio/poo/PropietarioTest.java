package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void notificarEstadoPropiedadDisponible() {
        LOG.info("Iniciación test EstadoDisponible");

        ArrayList<Propiedad> propiedades = new ArrayList<>();
        Propietario propietario = new Propietario("Juan", "Lopez", "3123456789", 30, "12365489", propiedades);
        Casa casa = new Casa("sur", "Casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        propiedades.add(casa);

        casa.setEstaArrendada(false);
        propietario.notificarEstado(casa); // está disponible

        LOG.info("Finalización test EstadoDisponible");
    }

    @Test
    public void notificarEstadoPropiedadArrendada() {
        LOG.info("Iniciación test EstadoArrendada");

        ArrayList<Propiedad> propiedades = new ArrayList<>();
        Propietario propietario = new Propietario("Pepe", "Pérez", "3987654321", 38, "78965123", propiedades);
        Apartamento apartamento = new Apartamento("norte", "apartamento basico", "edificio torre 2", 150000, 100000,propietario, true, 30000);
        propiedades.add(apartamento);

        apartamento.setEstaArrendada(true);
        propietario.notificarEstado(apartamento); // está arrendada

        LOG.info("Finalización test EstadoArrendada");
    }

    @Test
    public void testAgregarPropiedades() {
        LOG.info("Iniciación test AgregarPropiedades");

        ArrayList<Propiedad> propiedades = new ArrayList<>();
        Propietario propietario = new Propietario("Pedro", "Sanchez", "3023659788", 40, "1546932158", propiedades);
        Local local = new Local("norte", "Local basico ", "plazaFlora Local 2", 3000000, 150000, propietario, false,70000);

        propietario.agregarPropiedades(local);
        assertTrue(propietario.getPropiedadesPropietario().contains(local),"La propiedad esta en la lista de propiedades");

        LOG.info("Finalización test AgregarPropiedades");
    }

}
