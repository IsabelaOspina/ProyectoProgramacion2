package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class InmobiliariaTest {
    private static final Logger LOG = Logger.getLogger(Inmobiliaria.class.getName());

    //
    @Test
    public void getInstanciaInmobiliariaTest (){
        LOG.info("iniciando pruebas");
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Inmobiliaria instancia2 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria", "3217498776", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());

        assertEquals(instancia1, instancia2);
        LOG.info("finalizando prueba");
    }

    @Test
    public void testAgregarPropiedad() {
        LOG.info("iniciando pruebas");
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 1000000, 40000, propietario, false, 80000);
    
        instancia1.AgregarPropiedad(casa);
    
        assertTrue(instancia1.getPropiedades().contains(casa));
    }

    @Test
    public void testEliminarPropiedad() {
        LOG.info("iniciando pruebas");
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "12347", 1000000, 40000, propietario, false, 80000);
    
        instancia1.AgregarPropiedad(casa);
        instancia1.EliminarPropiedad(casa);
    
        assertFalse(instancia1.getPropiedades().contains(casa));
    }
    

    @Test
    public void TestAgregarPropiedadAlContrato(){

        LOG.info("iniciando prueba");
        
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);
        AgenteInmobiliario agenteInmobiliario = new AgenteInmobiliario("pedro", "lopez", "1234564556", 28, "1234225678", 1000000, new ArrayList<>(), new ArrayList<>());
        Cliente cliente = new Cliente("pancho", "nuñez", "2345675657", 21, "1092344356", 3000000, local);
        LocalDate fechaInicio = LocalDate.of(2024, 11, 05);
        LocalDate fechaFin = LocalDate.of(2025, 11, 05);
        ContratoArrendamientoReal contratoArrendamientoReal = new ContratoArrendamientoReal(local, cliente, agenteInmobiliario, fechaInicio, fechaFin);
        
        instancia1.getContratos().clear();

        instancia1.AgregarContrato(contratoArrendamientoReal);

        assertEquals(1, instancia1.getContratos().size());


    }

    @Test
    public void obtenerContratoPorClienteTest(){
        LOG.info("iniciando prueba");
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);
        AgenteInmobiliario agenteInmobiliario = new AgenteInmobiliario("pedro", "lopez", "1234564556", 28, "1234225678", 1000000, new ArrayList<>(), new ArrayList<>());
        Cliente cliente = new Cliente("pancho", "nuñez", "2345675657", 21, "1092344356", 3000000, local);
        LocalDate fechaInicio = LocalDate.of(2024, 11, 05);
        LocalDate fechaFin = LocalDate.of(2025, 11, 05);
        ContratoArrendamientoReal contratoArrendamientoReal = new ContratoArrendamientoReal(local, cliente, agenteInmobiliario, fechaInicio, fechaFin);

        instancia1.AgregarContrato(contratoArrendamientoReal);

        ArrayList<ContratoArrendamientoReal> contratoClientes = instancia1.obtenerContratoPorCliente("1092344356");
        assertEquals(1, contratoClientes.size());
        LOG.info("finalizando prueba");
    }


    @Test
    public void liberarPropiedadTest(){
        LOG.info("iniciando prueba");
        Inmobiliaria instancia1 = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria feliz", "3217498775", "inmobiliariafeliz@gmail.com", new ArrayList<>(), new ArrayList<>());
        Propietario propietario = new Propietario("jaime", "perez", "1234567890", 30, "12354", new ArrayList<>());
        Local local = new Local("local 3 via sur", "local basico ", "12365", 2000000, 50000, propietario, true, 10000);
        AgenteInmobiliario agenteInmobiliario = new AgenteInmobiliario("pedro", "lopez", "1234564556", 28, "1234225678", 1000000, new ArrayList<>(), new ArrayList<>());
        Cliente cliente = new Cliente("pancho", "nuñez", "2345675657", 21, "1092344356", 3000000, local);
        LocalDate fechaInicio = LocalDate.of(2024, 11, 05);
        LocalDate fechaFin = LocalDate.of(2025, 11, 05);
        ContratoArrendamientoReal contratoArrendamientoReal = new ContratoArrendamientoReal(local, cliente, agenteInmobiliario, fechaInicio, fechaFin);
        instancia1.AgregarContrato(contratoArrendamientoReal);

        LocalDate fechaActual = fechaFin.plusDays(1);
        instancia1.liberarPropiedad(contratoArrendamientoReal, fechaActual);
        assertFalse(local.isEstaArrendada());

    }


}
