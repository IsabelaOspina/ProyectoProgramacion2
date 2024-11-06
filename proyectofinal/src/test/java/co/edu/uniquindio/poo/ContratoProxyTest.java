package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.Proxy.ContratoArrendamientoProxy;

public class ContratoProxyTest {
    private static final Logger LOG = Logger.getLogger(ContratoArrendamientoProxy.class.getName());

    // prueba para obtener el contrato correctamente
    @Test
    public void ContratoProxyPermisoTest() {
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);
        AgenteInmobiliario agenteInmobiliario = new AgenteInmobiliario("pedro", "lopez", "1234564556", 28, "1234225678",
                1000000, new ArrayList<>(), new ArrayList<>());
        Cliente cliente = new Cliente("pancho", "nuñez", "2345675657", 21, "1092344356", 3000000, local);
        LocalDate fechaInicio = LocalDate.of(2024, 11, 05);
        LocalDate fechaFin = LocalDate.of(2025, 11, 05);
        ContratoArrendamientoReal contratoArrendamientoReal = new ContratoArrendamientoReal(local, cliente,
                agenteInmobiliario, fechaInicio, fechaFin);
        ContratoArrendamientoProxy contratoArrendamientoProxy = new ContratoArrendamientoProxy(
                contratoArrendamientoReal, cliente);

        String resultado = contratoArrendamientoProxy.obtenerInformacionContrato();
        assertEquals(resultado, contratoArrendamientoProxy.obtenerInformacionContrato());

        LOG.info("finalizando prueba");
    }

        

}
