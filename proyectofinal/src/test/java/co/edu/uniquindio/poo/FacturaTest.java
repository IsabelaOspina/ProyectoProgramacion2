package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class FacturaTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testCrearFactura() {
        LOG.info("Iniciación test CrearFactura");

        Propietario propietario = new Propietario("pedro", "Pérez", "3206598426", 36, "15489326", new ArrayList<>());
        Casa casa = new Casa("sur", "Casa basica", "CalimaMzBCs05", 200000, 10000, propietario, false, 40000);
        Cliente cliente = new Cliente("Luna", "Duran", "3001234567", 25, "123456789", 1000000, casa);
        EstadoTransaccion estado = EstadoTransaccion.VIGENTE;
        LocalDate fechaGenerado = LocalDate.of(2024, 10, 1);
        LocalDate fechaVencimiento = LocalDate.of(2024, 11, 10);

        Factura factura = new Factura(91, 400000, fechaGenerado, fechaVencimiento, estado, cliente);

        assertEquals(EstadoTransaccion.VIGENTE, factura.getEstadoTransaccion(),"El estado de la transacción es VIGENTE");

        LOG.info("Finalización test CrearFactura");
    }

    @Test
    public void testGenerarComprobante() {
        LOG.info("Iniciación test GenerarComprobante");

        Propietario propietario = new Propietario("pedro", "Pérez", "3123456789", 36, "75698264", new ArrayList<>());
        Casa casa = new Casa("sur", "Casa basica", "CalimaMzBCs05", 200000, 10000, propietario, false, 40000);
        Cliente cliente = new Cliente("Luna", "Duran", "3001234567", 25, "123456789", 1000000, casa);
        EstadoTransaccion estado = EstadoTransaccion.ENPROCESO;
        LocalDate fechaGenerado = LocalDate.of(2024, 11, 1);
        LocalDate fechaVencimiento = LocalDate.of(2024, 11, 15);

        Factura factura = new Factura(100, 400000, fechaGenerado, fechaVencimiento, estado, cliente);
        String comprobanteEsperado = "COMPROBANTE DE PAGO \n\n" +
                "numero de factura: 100\n" +
                "valor pagado: 400000.0\n" +
                "fecha de pago: 2024-11-01\n" +
                "estado de transaccion: ENPROCESO\n" +
                "cliente: 123456789\n";

        assertEquals(comprobanteEsperado, factura.generarComprobante());

        LOG.info("Finalización test GenerarComprobante");
    }

    @Test
    public void testEstadoTransaccion() {
        LOG.info("Iniciación test EstadoTransaccion");

        Propietario propietario = new Propietario("pedro", "Pérez", "3123456789", 36, "75698264", new ArrayList<>());
        Casa casa = new Casa("sur", "Casa basica", "CalimaMzBCs05", 200000, 10000, propietario, false, 40000);
        Cliente cliente = new Cliente("Luna", "Duran", "3001234567", 25, "123456789", 1000000, casa);
        EstadoTransaccion estado = EstadoTransaccion.VIGENTE;
        LocalDate fechaGenerado = LocalDate.of(2024, 11, 1);
        LocalDate fechaVencimiento = LocalDate.of(2024, 11, 15);

        Factura factura = new Factura(30, 300000, fechaGenerado, fechaVencimiento, estado, cliente);
        assertEquals(EstadoTransaccion.VIGENTE, factura.getEstadoTransaccion());

        factura.setEstadoTransaccion(EstadoTransaccion.VENCIDO);
        assertEquals(EstadoTransaccion.VENCIDO, factura.getEstadoTransaccion(),"El estado cambio");

        LOG.info("Finalización test EstadoTransaccion");
    }
}
