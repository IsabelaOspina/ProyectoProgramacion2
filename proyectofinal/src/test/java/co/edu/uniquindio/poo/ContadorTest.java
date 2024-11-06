package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

public class ContadorTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void testCalcularSueldoFinal() {
        LOG.info("Iniciación test CalcularSueldoFinal");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);
        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);
        Propietario propietario = new Propietario("José", "Gomez", "3178456789", 33, "1548963", new ArrayList<>());
        Casa casa = new Casa("Sur", "Casa básica", "Mz_A Cs_03", 200000, 50000, propietario, false, 60000);
        Local local = new Local("Centro", "Local basico ", "LC_02", 1500000, 40000, propietario, false, 150000);
        AgenteInmobiliario agenteInmobiliario = new AgenteInmobiliario("Julian", "Jimenez", "3112345678", 32,
                "123456789", 2000000, new ArrayList<>(), new ArrayList<>());

        agenteInmobiliario.getPropiedadesArrendadas().add(casa);
        agenteInmobiliario.getPropiedadesArrendadas().add(local);

        float sueldoFinal = contador.calcularSueldoFinal(agenteInmobiliario);
        float expectedSueldoFinal = 2000000 + casa.getComision() + local.getComision();
        assertEquals(expectedSueldoFinal, sueldoFinal);

        LOG.info("Finalización test CalcularSueldoFinal");
    }

    @Test
    public void testRegistrarIngreso() {
        LOG.info("Iniciación test RegistrarIngreso");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        // Limpiar el estado del RegistroContable antes de la prueba
        registroContable.setIngresos(new ArrayList<>());
        registroContable.setEgresos(new ArrayList<>());

        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);

        contador.registrarIngreso(5000000);

        assertEquals(5000000, registroContable.getIngresos().get(0));

        LOG.info("Finalización test RegistrarIngreso");
    }

    @Test
    public void testCalcularTotalIngresos() {
        LOG.info("Iniciación test CalcularTotalIngresos");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        // Limpiar el estado del RegistroContable antes de la prueba
        registroContable.setIngresos(new ArrayList<>());
        registroContable.setEgresos(new ArrayList<>());

        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);

        contador.registrarIngreso(500000);
        contador.registrarIngreso(300000);

        float totalIngresos = contador.calcularTotalIngresos();
        assertEquals(800000, totalIngresos);

        LOG.info("Finalización test CalcularTotalIngresos");
    }

    @Test
    public void testRegistrarEgreso() {
        LOG.info("Iniciación test RegistrarEgreso");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        // Limpiar el estado del RegistroContable antes de la prueba
        registroContable.setIngresos(new ArrayList<>());
        registroContable.setEgresos(new ArrayList<>());

        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);

        contador.registrarEgreso(1000000);

        assertEquals(1000000, registroContable.getEgresos().get(0));

        LOG.info("Finalización test RegistrarEgreso");
    }

    @Test
    public void testCalcularTotalEgresos() {
        LOG.info("Iniciación test CalcularTotalEgresos");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        // Limpiar el estado del RegistroContable antes de la prueba
        registroContable.setIngresos(new ArrayList<>());
        registroContable.setEgresos(new ArrayList<>());

        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);

        contador.registrarEgreso(200000);
        contador.registrarEgreso(300000);

        float totalEgresos = contador.calcularTotalEgresos();

        assertEquals(500000, totalEgresos);

        LOG.info("Finalización test CalcularTotalEgresos");
    }

    @Test
    public void testCalcularRentaTotal() {
        LOG.info("Iniciación test CalcularRentaTotal");

        Propietario propietario = new Propietario("José", "Gomez", "3178456789", 33, "1548963", new ArrayList<>());
        Casa casa = new Casa("sur", "casa basica", "Mz_A Cs_03", 200000, 50000, propietario, false, 20000);
        Cliente cliente = new Cliente("Laura", "González", "3001234567", 30, "6543217890", 1500000, casa);
        AgenteInmobiliario agente = new AgenteInmobiliario("Luis", "Velasquez", "3012345678", 35, "254896321", 2500000,
                new ArrayList<>(), new ArrayList<>());

        LocalDate fechaInicio = LocalDate.of(2024, 1, 1); // Fecha de inicio
        LocalDate fechaFin = LocalDate.of(2024, 6, 1); // Fecha de fin, se * por un mes antes

        ContratoArrendamientoReal contratoArrendamiento = new ContratoArrendamientoReal(casa, cliente, agente,
                fechaInicio, fechaFin);
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(new ArrayList<>(),
                new ArrayList<>());
        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);

        long rentaTotal = contador.calcularRentaTotal(contratoArrendamiento);

        assertEquals(1100000, rentaTotal);

        LOG.info("Finalización test CalcularRentaTotal");
    }

    @Test
    public void testIngresoRenta() {
        LOG.info("Iniciación test IngresoRenta");

        ArrayList<Float> ingresos = new ArrayList<>();
        ArrayList<Float> egresos = new ArrayList<>();
        RegistroContable registroContable = RegistroContable.getInstanciaRegistroContable(ingresos, egresos);

        Contador contador = new Contador("Samuel", "Arias", "3123456789", 43, "1321654987", 2500000, registroContable);
        long rentaTotal = 132000;

        contador.ingresoRenta(rentaTotal);

        assertEquals(1, registroContable.getIngresos().size());
        assertEquals(rentaTotal, registroContable.getIngresos().get(0));

        LOG.info("Finalización test IngresoRenta");
    }
}