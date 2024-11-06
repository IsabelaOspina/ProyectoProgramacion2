package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Decorator.ConAireAcondicionado;
import co.edu.uniquindio.poo.Decorator.ConParqueadero;

public class DecoradorPropiedadTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testDescripcionConAireYParqueadero() {
        LOG.info("Iniciación test ConAireAcondicionadoYParqueadero");

        Propietario propietario = new Propietario("Johan", "Gonzalez", "3178456789", 37, "1548963", new ArrayList<>());
        Casa casa = new Casa("centro", "casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        
        Componente propiedadConAireYParqueadero = new ConParqueadero(new ConAireAcondicionado(casa));

        assertEquals("casa basica, con aire acondicionado, con parqueadero", propiedadConAireYParqueadero.getDescripcion());

        LOG.info("Iniciación test ConAireAcondicionadoYParqueadero");
    }
}
