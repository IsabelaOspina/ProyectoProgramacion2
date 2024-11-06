package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CasaTest {
    private static final Logger LOG = Logger.getLogger(Casa.class.getName());
    
    //prueba recibir el constructor de manera correcta 
    @Test
    public void TestConstructor(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 2000000, 150000, propietario, true, 40000);

        assertEquals("sur", casa.getLocalizacion());
        assertEquals("casa basica", casa.getDescripcion());
        assertEquals("12347", casa.getIdPropiedad());
        assertEquals(2000000, casa.getValorArriendo());
        assertEquals(150000, casa.getValorDeposito());
        assertEquals(propietario, casa.getPropietario());
        assertEquals(true, casa.isEstaArrendada());
        assertEquals(40000, casa.getComision());
        LOG.info("finalizando prueba");
    }

    //prueba del set para el numero de pruebas 
    @Test
    public void setNumeroPisosTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 2000000, 150000, propietario, true, 40000);

        casa.setNumeroPisos(2);

        assertEquals(2, casa.getNumeroPisos());
        LOG.info("finalizando prueba");
    }

    //prueba para verificar que la descripcion sea correcta
    @Test
    public void getDescripcionTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 2000000, 150000, propietario, true, 40000);

        assertEquals("casa basica", casa.getDescripcion());
        LOG.info("finalizando prueba");

    }

    //prueba para obtener el estrato de la casa 
    @Test
    public void definirEstratoTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 2000000, 150000, propietario, true, 40000);

        assertEquals(1, casa.definirEstrato());
        LOG.info("finalizando prueba");

        casa.setLocalizacion("centro");
        assertEquals(2, casa.definirEstrato());

        casa.setLocalizacion("norte");
        assertEquals(3, casa.definirEstrato());

        LOG.info("finalizando prueba");
    }


}
