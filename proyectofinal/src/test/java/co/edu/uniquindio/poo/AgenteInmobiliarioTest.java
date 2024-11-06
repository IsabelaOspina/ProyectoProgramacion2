package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AgenteInmobiliarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testArrendarPropiedad() {
        LOG.info("Iniciación test ArrendarPropiedad");

        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Apartamento apartamento = new Apartamento("norte", "apartamento basico", "edificio torre 2", 150000, 100000, propietario, false, 30000);
        Cliente cliente = new Cliente("Laura", "Sánchez", "3001234567", 30, "8715978", 1500000, apartamento);
        AgenteInmobiliario agente = new AgenteInmobiliario("Marta", "Gómez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());

        boolean arrendada = agente.ArrendarPropiedad(apartamento, cliente);
        assertTrue(arrendada);

        boolean YaArrendada = agente.ArrendarPropiedad(apartamento, cliente); //arrendar nuevamente
        assertFalse(YaArrendada);

        LOG.info("Finalización test ArrendarPropiedad");
    }

    @Test
    public void testalCularValorFinalPropiedad() {
        LOG.info("Iniciación test CalcularValorFinalPropiedad");

        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Apartamento apartamento = new Apartamento("norte", "apartamento basico", "edificio torre 2", 250000, 100000, propietario, false, 30000);
        AgenteInmobiliario agente = new AgenteInmobiliario("Marta", "Gómez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());

        float valorFinal = agente.calcularValorFinalPropiedad(apartamento);
        assertEquals(280000, valorFinal);

        LOG.info("Finalización test CalcularValorFinalPropiedad");
    }

    @Test
    public void testGenerarContratoArrendamiento() {
        LOG.info("Iniciación test GenerarContrato");

        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Local local = new Local("norte", "Local basico", "plazaFlora Local 2", 3000000, 150000, propietario, false,70000);
        Cliente cliente = new Cliente("Laura", "Sánchez", "3001234567", 30, "8715978", 4500000, local);
        AgenteInmobiliario agente = new AgenteInmobiliario("Marta", "Gómez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());
        LocalDate fechaInicio = LocalDate.of(2024, 11, 1);
        LocalDate fechaFin = LocalDate.of(2024, 12, 1);

        ContratoArrendamientoReal contrato = agente.generContratoArrendamiento(local, cliente, agente, fechaInicio, fechaFin);

        assertEquals("norte", contrato.getPropiedad().getLocalizacion());
        assertEquals("Laura", contrato.getCliente().getNombrePersona());
        assertEquals("Marta", contrato.getAgenteInmobiliario().getNombrePersona());
        assertEquals(3070000, contrato.getValorFinal()); // se esta tomando solo la comisión y el valor de arriendo
        assertEquals(fechaInicio, contrato.getFechaInicio());
        assertEquals(fechaFin, contrato.getFechaFin());
        assertEquals("local basico ", contrato.getPropiedad().getDescripcion());

        LOG.info("Finalización test GenerarContrato");
    }

    @Test
    public void testNotificarEstado() {
        LOG.info("Iniciación test NotificarEstado");
        
        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Local local = new Local("norte", "Local basico", "plazaFlora Local 2", 3000000, 150000, propietario, false,70000);
        AgenteInmobiliario agente = new AgenteInmobiliario("Luis", "Velasquez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());

        agente.notificarEstado(local);
        local.setEstaArrendada(true);
        agente.notificarEstado(local);

        LOG.info("Finalización test NotificarEstado");
    }

    @Test
    public void SetPropiedadesArrendadas() {
        LOG.info("Iniciación test SetPropiedadesArrendadas");

        Propietario propietario = new Propietario("Pepe", "Pérez", "987654321", 38, "ID001", new ArrayList<>());
        Local local = new Local("norte", "Local basico", "plazaFlora Local 2", 3000000, 150000, propietario, false,70000);
        Apartamento apartamento = new Apartamento("norte", "apartamento", "edificio torre 2", 250000, 100000, propietario, false, 30000);
        AgenteInmobiliario agente = new AgenteInmobiliario("Luis", "Velasquez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());

        assertTrue(agente.getPropiedadesArrendadas().isEmpty());

        ArrayList<Propiedad> propiedadesArrendadas = new ArrayList<>();
        propiedadesArrendadas.add(local);
        propiedadesArrendadas.add(apartamento);
        agente.setPropiedadesArrendadas(propiedadesArrendadas);

        // Verificar que las propiedades arrendadas se han actualizado correctamente
        assertEquals(2, agente.getPropiedadesArrendadas().size());
        assertTrue(agente.getPropiedadesArrendadas().contains(local));
        assertTrue(agente.getPropiedadesArrendadas().contains(apartamento));

        LOG.info("Finalización test SetPropiedadesArrendadas");
    }

    @Test
    public void SetClientes() {
        LOG.info("Iniciación test SetPropiedadesArrendadas");

        Propietario propietario = new Propietario("Andres", "Trujillo", "3215698447", 38, "123456789", new ArrayList<>());
        Local local = new Local("norte", "Local basico", "plazaFlora Local 2", 3000000, 150000, propietario, false,90000);
        Apartamento apartamento = new Apartamento("norte", "apartamento", "edificio torre 2", 250000, 100000, propietario, false, 40000);
        Cliente cliente1 = new Cliente("Tatiana", "Arias", "3122234567", 30, "123654789", 1500000, local);
        Cliente cliente2 = new Cliente("Diego", "Cortes", "3236654321", 28, "789456321", 400000, apartamento);
        AgenteInmobiliario agente = new AgenteInmobiliario("Luis", "Velasquez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());

        assertTrue(agente.getClientes().isEmpty());

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        agente.setClientes(clientes);
        assertEquals(2, agente.getClientes().size());
        assertTrue(agente.getClientes().contains(cliente1));
        assertTrue(agente.getClientes().contains(cliente2));
    }

}
