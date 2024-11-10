package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class ContratoArrendamientoRealTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testCrearContrato() {
        LOG.info("Iniciación test CrearContrato");

        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Apartamento apartamento = new Apartamento("norte", "apartamento basico", "edificio torre 2", 150000, 100000, propietario, true, 30000);
        Cliente cliente = new Cliente("Laura", "Sánchez", "3001234567", 30, "10924586", 1500000, apartamento);
        AgenteInmobiliario agente = new AgenteInmobiliario("Marta", "Gómez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());
        LocalDate fechaInicio = LocalDate.of(2024, 11, 3);
        LocalDate fechaFin = LocalDate.of(2024, 11, 30);
    
        ContratoArrendamientoReal contrato = new ContratoArrendamientoReal(apartamento, cliente, agente, fechaInicio, fechaFin);
    
        assertEquals("norte", contrato.getPropiedad().getLocalizacion());
        assertEquals("Laura", contrato.getCliente().getNombrePersona());
        assertEquals("Marta", contrato.getAgenteInmobiliario().getNombrePersona());
        assertEquals(180000, contrato.getValorFinal()); // se esta tomando solo la comisión y el valor de arriendo
        assertEquals(fechaInicio, contrato.getFechaInicio());
        assertEquals(fechaFin, contrato.getFechaFin());
        assertEquals("apartamento basico", contrato.getPropiedad().getDescripcion());
        
        LOG.info("Finalización test CrearContrato");
    }

    @Test
    public void testObtenerInformacionContrato() {
        LOG.info("Iniciación test ObtenerInformación");
        
        Propietario propietario = new Propietario("Pepe", "Pérez", "3587654321", 38, "1548963255", new ArrayList<>());
        Apartamento apartamento = new Apartamento("norte", "apartamento basico", "edificio torre 2", 150000, 100000, propietario, true, 30000);
        Cliente cliente = new Cliente("Laura", "Sánchez", "3001234567", 30, "8715978", 1500000, apartamento);
        AgenteInmobiliario agente = new AgenteInmobiliario("Marta", "Gómez", "3012345678", 35, "254896321", 2500000, new ArrayList<>(), new ArrayList<>());
        LocalDate fechaInicio = LocalDate.of(2024, 10, 1);
        LocalDate fechaFin = LocalDate.of(2024, 11, 1);

        ContratoArrendamientoReal contrato = new ContratoArrendamientoReal(apartamento, cliente, agente, fechaInicio, fechaFin);
        String informacionEsperada = "CONTRATO DE ARRENDAMIENTO\n\n" +
                "Propiedad: norte\n" +
                "Agente Inmobiliario: Marta\n" +
                "Arrendatario: Pepe\n" +
                "Fecha de inicio: 2024-10-01\n" +
                "Fecha de fin: 2024-11-01\n" +
                "Monto mensual de la renta: $180000.0\n"; 

        assertEquals(informacionEsperada, contrato.obtenerInformacionContrato());
        LOG.info("Finalización test ObtenerInformación");
    }
}
