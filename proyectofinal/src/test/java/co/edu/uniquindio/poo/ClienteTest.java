package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ClienteTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testCrearCliente() {
        LOG.info("Iniciación test CrearCliente");

        Propietario propietario = new Propietario("Pepe", "Pérez", "387654321", 38, "8546923", new ArrayList<>());
        Casa casa = new Casa("sur", "Casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        Cliente cliente = new Cliente("Laura", "Sánchez", "3204559035", 44, "6598965", 1500000, casa);

        assertEquals("Laura", cliente.getNombrePersona());
        assertEquals("Sánchez", cliente.getApellidopersona());
        assertEquals("3204559035", cliente.getTelefonoPersona());
        assertEquals("6598965", cliente.getIdPersona());
        assertEquals(44, cliente.getEdad());
        assertEquals(1500000, cliente.getPresupuesto());
        assertEquals(casa, cliente.getPreferencia());

        LOG.info("Finalización test CrearCliente");
    }
    
    @Test
    public void testPresupuestoCliente() {
        LOG.info("Iniciación test PresupuestoCliente");

        Propietario propietario = new Propietario("Lina", "Gonzales", "987654321", 50, "65948236", new ArrayList<>());
        Casa casa = new Casa("sur", "Casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        Cliente cliente = new Cliente("Carlos", "Gómez", "3089876543", 20, "ID234", 250000, casa);

        assertEquals(250000, cliente.getPresupuesto());
        
        LOG.info("Finalización test PresupuestoCliente");
    }

    @Test
    public void testPreferenciaCliente() {
        LOG.info("Finalización test PreferenciaCliente");

        Propietario propietario = new Propietario("Ana", "Martínez", "987654321", 35, "ID005", new ArrayList<>());
        Apartamento apartamento = new Apartamento("norte", "Apartamento basico", "Piso03Apt04", 300000, 150000, propietario, false, 50000);
        Cliente cliente = new Cliente("Liliana", "Botero", "3012345678", 28, "45896325", 350000, apartamento);

        assertEquals(apartamento, cliente.getPreferencia());
        LOG.info("Finalización test PreferenciaCliente");
    }
}
