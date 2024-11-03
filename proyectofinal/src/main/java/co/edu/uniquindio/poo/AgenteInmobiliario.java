package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import co.edu.uniquindio.poo.Observer.Observador;


public class AgenteInmobiliario extends Persona implements Observador{

    private float sueldoMinimo;
    private ArrayList<Propiedad> propiedadesArrendadas;
    private ArrayList<Cliente> clientes;
    

    public AgenteInmobiliario(String nombrePersona, String apellidopersona, String telefonoPersona, int edad,
            String idPersona, float sueldoMinimo, ArrayList<Propiedad> propiedadesArrendadas,ArrayList<Cliente> clientes ) {
        super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
        this.sueldoMinimo = sueldoMinimo;
        this.propiedadesArrendadas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public boolean ArrendarPropiedad(Propiedad propiedad, Cliente cliente){
        if(propiedad.isEstaArrendada() == false){
            propiedad.setEstaArrendada(true);
            System.out.println("Se arrendo la  "+ propiedad);
            propiedadesArrendadas.add(propiedad);
            return true;
        }else{
            System.out.println("Ya se encuentra arrendada la  " + propiedad );
            return false;
        } 

    }
        //calcular el valor final de la propiedad
        // preguntar si va en esta clase o en contador
    // tenerlo en cuenta para el contarto 
    public float calcularValorFinalPropiedad(Propiedad propiedad){
        float valorFinalPropiedad= propiedad.getComision() + propiedad.getValorArriendo();
        return valorFinalPropiedad;
    }

    // metodo para generar contrato
    public ContratoArrendamientoReal generContratoArrendamiento(Propiedad propiedad, Cliente cliente,
            AgenteInmobiliario agenteInmobiliario, LocalDate fechaInicio, LocalDate fechaFin){
        return new ContratoArrendamientoReal(propiedad, cliente, agenteInmobiliario, fechaInicio, fechaFin);

    }

    // metodo del observer para notificar al agente inmobiliario cuando una propiedad sea arrendada o quede disponible 
    @Override
    public void notificarEstado(Propiedad propiedad){
        if(propiedad.isEstaArrendada() == false ){
            System.out.println("la propiedad " + propiedad.getIdPropiedad()+ " ahora esta disponible");
        }else{
            System.out.println("la propiedad "+ propiedad.getIdPropiedad()+ " ahora esta arrendada");
        }
    }

    public float getSueldoMinimo() {
        return sueldoMinimo;
    }

    public void setSueldoMinimo(float sueldoMinimo) {
        this.sueldoMinimo = sueldoMinimo;
    }

    public ArrayList<Propiedad> getPropiedadesArrendadas() {
        return propiedadesArrendadas;
    }

    public void setPropiedadesArrendadas(ArrayList<Propiedad> propiedadesArrendadas) {
        this.propiedadesArrendadas = propiedadesArrendadas;
    }
   

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "AgenteInmobiliario [sueldoMinimo=" + sueldoMinimo + ", propiedadesArrendadas=" + propiedadesArrendadas
                + ", cliente=" + clientes + ", getNombrePersona()=" + getNombrePersona() + ", getApellidopersona()="
                + getApellidopersona() + ", getTelefonoPersona()=" + getTelefonoPersona() + ", getEdad()=" + getEdad()
                + ", getSueldoMinimo()=" + getSueldoMinimo() + ", getPropiedadesArrendadas()="
                + getPropiedadesArrendadas() + ", getCliente()=" + getClientes() + "]";
    }

  

   


    
}
