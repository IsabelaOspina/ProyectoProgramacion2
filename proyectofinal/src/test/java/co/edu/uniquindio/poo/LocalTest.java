package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;


import org.junit.jupiter.api.Test;

public class LocalTest {
    private static final Logger LOG = Logger.getLogger(Local.class.getName());

    //test para inicializar un local correctamentee
    @Test
    public void TestConstructor(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);

        assertEquals("local 3 via sur", local.getLocalizacion());
        assertEquals("local basico ", local.getDescripcion());
        assertEquals("12365", local.getIdPropiedad());
        assertEquals(2000000, local.getValorArriendo());
        assertEquals(50000, local.getValorDeposito());
        assertEquals(propietario, local.getPropietario());
        assertEquals(true, local.isEstaArrendada());
        assertEquals(10000, local.getComision());
        LOG.info("finalizando prueba");
    }


    //test para set del espacio de bodega
    @Test
    public void setEspacioBodegaTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);

        local.setEspacioBodega(45);

        assertEquals(45, local.getEspacioBodega());
        LOG.info("finalizando prueba ");

    }

    //test para definir el estrato 
    @Test
    public void definirEstratoTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);

        local.setEspacioBodega(45);
        assertEquals(3, local.definirEstrato());

        local.setEspacioBodega(54);
        assertEquals(4, local.definirEstrato());
        LOG.info("finalizando prueba");
    }

    //test para verificar descripcion del local
    @Test
    public void getDescripcionTest(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);

        assertEquals("local basico ", local.getDescripcion());
    }



    


    
    
}
