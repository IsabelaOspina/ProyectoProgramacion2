package co.edu.uniquindio.poo;
import java.time.Period; 

public class Contador extends Persona {
    private float sueldoContador;
    private RegistroContable registroContable;

    public Contador(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            float sueldoContador, RegistroContable registroContable) {
                super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
                this.sueldoContador = sueldoContador;
                this.registroContable=registroContable;
    }

    // metodo para que el contador calcule el sueldo final del agente inmobiliario
    public float calcularSueldoFinal(AgenteInmobiliario agenteInmobiliario){
        float sueldoFinal = agenteInmobiliario.getSueldoMinimo();
        for (Propiedad propiedad: agenteInmobiliario.getPropiedadesArrendadas()){
            sueldoFinal+= propiedad.getComision();
        }
        return sueldoFinal;
    }

    // metodo  para registrar ingreso 
    public void registrarIngreso(float ingreso) {
        registroContable.agregarIngreso(ingreso);
        System.out.println("Ingreso registrado: " + ingreso);
    }
    
    // metodo para calcular total ingresos
    public float calcularTotalIngresos(){
        float TotalIngresos=0;
        for(float ingreso:registroContable.getIngresos()){
            TotalIngresos+=ingreso;
        }
        return TotalIngresos;
    }

    // metodo para calcular total de egresos
    public float calcularTotalEgresos(){
        float TotalEgresos=0;
        for(float egreso:registroContable.getEgresos()){
            TotalEgresos+=egreso;
        }
        return TotalEgresos;
    }


    //metodo para registrar egreso
    public void registrarEgreso(float egreso) {
        registroContable.agregarEgreso(egreso);
        System.out.println("Egreso registrado:"+ egreso);
    }


    // metodo para recibir la renta de una propiedad segun el tiempo de contrato
    public long calcularRentaTotal(ContratoArrendamientoReal contratoArrendamiento){
        Period periodo= Period.between(contratoArrendamiento.getFechaInicio(),contratoArrendamiento.getFechaFin());
        // convertir el periodo a meses
        int mesesTotales=periodo.getYears()*12 + periodo.getMonths();
        // calcular el valor de la renta total 
        long rentaTotal= (long)(mesesTotales*contratoArrendamiento.getValorFinal());
        return rentaTotal;

    }

    // metodo para agregar la renta total de una propiedad a los ingresos
    public void ingresoRenta(long rentaTotal){
        registroContable.agregarIngreso(rentaTotal);
        System.out.println(" se agrego la renta total de "+ rentaTotal+ "a los ingresos");
    }


    public float getSueldoContador() {
        return sueldoContador;
    }

    public void setSueldoContador(float sueldoContador) {
        this.sueldoContador = sueldoContador;
    }
}
    
    

    

