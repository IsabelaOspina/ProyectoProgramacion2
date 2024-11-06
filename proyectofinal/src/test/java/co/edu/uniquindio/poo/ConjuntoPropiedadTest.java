package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.Composite.ConjuntoPropiedad;
import co.edu.uniquindio.poo.Factory.IPropiedad;

public class ConjuntoPropiedadTest {
    private static final Logger LOG = Logger.getLogger(ConjuntoPropiedad.class.getName());

    //inicializar un conjunto de manera correcta
    @Test
    public void CrearConjuntoTest(){
        LOG.info("iniciando prueba");
        ConjuntoPropiedad conjuntoPropiedad = new ConjuntoPropiedad("conjunto cristal");

        assertEquals("conjunto cristal", conjuntoPropiedad.getNombreConjunto());
        assertTrue(conjuntoPropiedad.getPropiedadesConjunto().isEmpty());
        LOG.info("finalizando prueba");

    }

    //agragar una propiedad a un conjunto  ya creado 
    @Test
    public void agregarPropiedadAlConjuntoTest(){
        LOG.info("iniciando prueba");
        ConjuntoPropiedad conjuntoPropiedad = new ConjuntoPropiedad("conjunto cristal");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        IPropiedad propiedad = new Casa("centro", "casa basica", "12345", 1500000, 80000, propietario, false, 40000);
        IPropiedad propiedad2 = new Casa("centro", "casa basica", "12347", 2000000, 10000, propietario, false, 80000);
        conjuntoPropiedad.agregarPropiedadAlConjunto(propiedad);
        conjuntoPropiedad.agregarPropiedadAlConjunto(propiedad2);
        
        assertEquals(2, conjuntoPropiedad.getPropiedadesConjunto().size());
        assertEquals(propiedad.getClass(), conjuntoPropiedad.getTipoPropiedad());
        LOG.info("finalizando prueba");
    
    }
    


    //prueba para calculas el estrato de un conjunto
    @Test
    public void testCalculoEstratoPromedio() {
        LOG.info("iniciando prueba");
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        ConjuntoPropiedad conjunto = new ConjuntoPropiedad("Conjunto Residencial");
        IPropiedad propiedad1 = new Casa("centro", "casa basica", "12345", 1500000, 80000, propietario, false, 40000);
        IPropiedad propiedad2 = new Casa("centro", "casa basica", "1236", 1000000, 100000, propietario, false, 50000);

        conjunto.agregarPropiedadAlConjunto(propiedad1);
        conjunto.agregarPropiedadAlConjunto(propiedad2);


        // sirve para llamar el metodo directo de la clase 
        int estratoPromedio = conjunto.definirEstrato();

        assertEquals(2, estratoPromedio);
        LOG.info("finalizando prueba");
    }

    // prueba para el funcionamiento de el calculo de la renta total
    @Test
    public void rentaTotalConjuntoTest(){
        LOG.info("iniciando prueba");
        AgenteInmobiliario agente = new AgenteInmobiliario("pedro", "lopez", "1234564556", 28, "1234225678", 1000000, new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        ConjuntoPropiedad conjunto = new ConjuntoPropiedad("Conjunto Residencial");
        IPropiedad propiedad1 = new Casa("centro", "casa basica", "12345", 1500000, 80000, propietario, false, 40000);
        IPropiedad propiedad2 = new Casa("centro", "casa basica", "1236", 1000000, 100000, propietario, false, 50000);
    
        conjunto.agregarPropiedadAlConjunto(propiedad1);
        conjunto.agregarPropiedadAlConjunto(propiedad2);

        float rentaTotalConjunto = conjunto.rentaTotalConjunto(agente);

        assertEquals(2590000, rentaTotalConjunto);


    }
}
