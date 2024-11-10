package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Contador extends Persona {
    private float sueldoContador;
    private RegistroContable registroContable;
    ArrayList<ContratoArrendamientoReal> listaContrato = new ArrayList<ContratoArrendamientoReal>();

    public Contador(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            float sueldoContador, RegistroContable registroContable) {
        super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
        this.sueldoContador = sueldoContador;
        this.registroContable = registroContable;
    }

    // metodo para que el contador calcule el sueldo final del agente inmobiliario
    public float calcularSueldoFinal(AgenteInmobiliario agenteInmobiliario, int mes, int año,
            ArrayList<ContratoArrendamientoReal> listaContrato) {
        float sueldoFinal = agenteInmobiliario.getSueldoMinimo();
        for (ContratoArrendamientoReal contrato : listaContrato) {
            if (contrato.getAgenteInmobiliario().equals(agenteInmobiliario)) { // Verifica que el contrato es del agente
                                                                               // especificado
                LocalDate fechaInicio = contrato.getFechaInicio();
                if (fechaInicio.getMonthValue() == mes && fechaInicio.getYear() == año) {
                    sueldoFinal += contrato.getPropiedad().getComision(); // Suma la comisión de la propiedad del
                                                                          // contrato
                }
            }
        }
        return sueldoFinal;
    }

    // metodo para registrar ingreso
    public void registrarIngreso(float ingreso, boolean haveComission) {
        float ingresoInmobiliaria = haveComission ? ingreso * 0.40f : ingreso;
        registroContable.agregarIngreso(ingresoInmobiliaria);
    }

    // metodo para calcular total ingresos
    public float calcularTotalIngresos() {
        float TotalIngresos = 0;
        for (float ingreso : registroContable.getIngresos()) {
            TotalIngresos += ingreso;
        }
        return TotalIngresos;
    }

    // metodo para calcular total de egresos
    public float calcularTotalEgresos(AgenteInmobiliario agenteInmobiliario, int mes, int año,
            ArrayList<ContratoArrendamientoReal> listaContrato) {
        float TotalEgresos = 0;
        for (float egreso : registroContable.getEgresos()) {
            TotalEgresos += egreso;
        }

        float sueldoAgente = calcularSueldoFinal(agenteInmobiliario, mes, año, listaContrato);

        // Agregar el sueldo del contador a los egresos
        TotalEgresos += (sueldoContador + sueldoAgente);

        return TotalEgresos;
    }

    // metodo para registrar egreso
    public void registrarEgreso(float egreso) {
        registroContable.agregarEgreso(egreso);
        System.out.println("Egreso registrado:" + egreso);
    }

    // metodo para recibir la renta de una propiedad segun el tiempo de contrato
    public long calcularRentaTotal(ContratoArrendamientoReal contratoArrendamiento) {
        Period periodo = Period.between(contratoArrendamiento.getFechaInicio(), contratoArrendamiento.getFechaFin());
        // convertir el periodo a meses
        int mesesTotales = periodo.getYears() * 12 + periodo.getMonths();
        // calcular el valor de la renta total
        long rentaTotal = (long) (mesesTotales * contratoArrendamiento.getValorFinal());
        return rentaTotal;

    }

    // metodo para agregar la renta total de una propiedad a los ingresos
    public void ingresoRenta(long rentaTotal) {
        float ingresoInmobiliaria = rentaTotal * 0.40f;
        registroContable.agregarIngreso(ingresoInmobiliaria);
        System.out.println("Se agrego la renta total de " + ingresoInmobiliaria + " a los ingresos de la inmobiliaria");
    }

    public float getSueldoContador() {
        return sueldoContador;
    }

    public void setSueldoContador(float sueldoContador) {
        this.sueldoContador = sueldoContador;
    }
}

