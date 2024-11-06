package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Decorator.ConParqueadero;

public class ConParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testConParqueaderoDescripcion() {
        LOG.info("Iniciación test ConParqueaderoDescripción");
    
        Propietario propietario = new Propietario("José", "Gomez", "3178456789", 33, "1548963", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        Componente propiedadDecorada = new ConParqueadero(casa);

        assertEquals("casa basica, con parqueadero", propiedadDecorada.getDescripcion());

        LOG.info("Finalización test ConParqueaderoDescripción");
    }

}
