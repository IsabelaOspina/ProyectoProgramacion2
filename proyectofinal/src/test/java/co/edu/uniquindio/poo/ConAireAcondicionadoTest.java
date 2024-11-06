package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Decorator.ConAireAcondicionado;

public class ConAireAcondicionadoTest {
        private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testConAireAcondicionado() {
        LOG.info("Iniciación test ConAireAcondicionado");
    
        Propietario propietario = new Propietario("José", "Gomez", "3178456789", 33, "1548963", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        Componente propiedadDecorada = new ConAireAcondicionado(casa);

        assertEquals("casa basica, con aire acondicionado", propiedadDecorada.getDescripcion());

        LOG.info("Finalización test ConAireAcondicionado");
    }
}