package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class RegistroContableTest {
    private static final Logger LOG = Logger.getLogger(RegistroContable.class.getName());

    //preuba instancia unica
    @Test
    public void getInstanciaRegistroContableTest(){
        LOG.info("iniciando prueba");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.agregarIngreso(5000000);
        registroContable.agregarEgreso(2000000);

        RegistroContable registroContable2= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        
        assertEquals(registroContable, registroContable2);
        LOG.info("finalizando prueba");

    }
    
    //pueba para agregar un ingresos a la lista del registro contable
    @Test
    public void agregarIngresoTest(){
        LOG.info("iniciando prueba ");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.agregarIngreso(5000000);

        assertEquals(1, registroContable.getIngresos().size());
        LOG.info("finalizando prueba");

    }


    //prueba para agregar un egreso a la lista del registro contable 
    @Test
    public void agregarEgresoTest() {
        LOG.info("Iniciando prueba de agregarEgreso");

        // Asegura que `registroContableUnico` esté limpio configurando una lista vacía de ingresos y egresos
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        // Reinicia las listas por si hay datos residuales
        registroContable.getIngresos().clear();
        registroContable.getEgresos().clear();

        // Agrega dos egresos
        registroContable.agregarEgreso(2000000);
        registroContable.agregarEgreso(1500000);

        // Verifica que la lista de egresos contenga solo dos elementos
        assertEquals(2, registroContable.getEgresos().size());

        LOG.info("Finalizando prueba de agregarEgreso");
    }
    

    //pueba para obtener el valor de ingreso
    @Test
    public void getIngresosTest(){
        LOG.info("iniciando prueba");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.agregarIngreso(5000000);
        assertEquals(5000000, registroContable.getIngresos().get(0));
        LOG.info("finalizando prueba");
    }

    //prueba para obtener el valor de los egresos
    @Test
    public void getEgresosTest(){
        LOG.info("iniciando prueba");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.getIngresos().clear();
        registroContable.getEgresos().clear();

        registroContable.agregarEgreso(20000);
        assertEquals(20000, registroContable.getEgresos().get(0));
        LOG.info("finalizando prueba");
    }

    //pueba para reemplazar un valor de ingresos
    @Test
    public void setIngresosTest(){
        LOG.info("iniciando prueba");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.agregarIngreso(5000000);

        ArrayList<Float> nuevosIngresos = new ArrayList<>();
        nuevosIngresos.add(400000f);

        registroContable.setIngresos(nuevosIngresos);
        LOG.info("finalizando prueba");
    
    }

    //pueba para reemplazar un valor de egresos
    @Test
    public void setEgresosTest(){
        LOG.info("iniciando prueba");
        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable= RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        registroContable.agregarEgreso(800000);

        ArrayList<Float> nuevosEgresos = new ArrayList<>();
        nuevosEgresos.add(300000f);

        registroContable.setEgresos(nuevosEgresos);
        LOG.info("finalizando prueba");
    
    }






}
