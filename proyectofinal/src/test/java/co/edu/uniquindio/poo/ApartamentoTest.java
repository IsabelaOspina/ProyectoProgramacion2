package co.edu.uniquindio.poo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class ApartamentoTest {
    private static final Logger LOG = Logger.getLogger(Apartamento.class.getName());

    //prueba para el correcto ingreso del constructor 
    @Test
    public void TestConstructor(){
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Apartamento apartamento = new Apartamento("sur", "apartamento basico", "12345", 1500000, 250000, propietario, true, 60000);

        assertEquals("sur", apartamento.getLocalizacion());
        assertEquals("apartamento basico", apartamento.getDescripcion());
        assertEquals("12345", apartamento.getIdPropiedad());
        assertEquals(1500000, apartamento.getValorArriendo());
        assertEquals(250000, apartamento.getValorDeposito());
        assertEquals(propietario, apartamento.getPropietario());
        assertEquals(true, apartamento.isEstaArrendada());
        assertEquals(60000, apartamento.getComision());
        LOG.info("finalizando prueba");
    }


//prueba de set para el valor de la administracion m
@Test
public void setValorAdministracionTest(){
    LOG.info("iniciando prueba");
    Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
    Apartamento apartamento = new Apartamento("sur", "apartamento basico", "12345", 1500000, 250000, propietario, true, 60000);

    apartamento.setValorAdministracion(40000);
    assertEquals(40000, apartamento.getValorAdministracion());
    LOG.info("finalizando prueba");

}

//prueba para obtener la descricion del apartamento
@Test
public void getDescripcionTest(){
    LOG.info("iniciando prueba");
    Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
    Apartamento apartamento = new Apartamento("sur", "apartamento basico", "12345", 1500000, 250000, propietario, true, 60000);

    assertEquals("apartamento basico", apartamento.getDescripcion());
    LOG.info("finalizando prueba");
} 

//prueba para obtener el estrato del apartamento
@Test
public void definirEstratoTest(){
    LOG.info("iniciando prueba");
    Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
    Apartamento apartamento = new Apartamento("sur", "apartamento basico", "12345", 1500000, 250000, propietario, true, 60000);

    apartamento.setValorAdministracion(100000);
    assertEquals(4, apartamento.definirEstrato());

    apartamento.setValorAdministracion(200000);
    assertEquals(5, apartamento.definirEstrato());


    LOG.info("finalizando prueba");


}
}




