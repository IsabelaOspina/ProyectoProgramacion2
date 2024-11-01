package co.edu.uniquindio.poo;

import java.util.ArrayList;

import co.edu.uniquindio.poo.Observer.Observador;

public class Propietario extends Persona implements Observador{
    private ArrayList <Propiedad> propiedadesPropietario;

    public Propietario(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            ArrayList<Propiedad> propiedadesPropietario) {
                super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
            
                if (propiedadesPropietario != null) {
                    this.propiedadesPropietario = propiedadesPropietario;
                } else {
                    this.propiedadesPropietario = new ArrayList<>(); // Inicializa con una lista vacía
                }
            }

    


     // metodo del observer para notificar al propietario cuando una propiedad suya sea arrendada o quede disponible 
    @Override
    public void notificarEstado(Propiedad propiedad){
        if(propiedadesPropietario.contains(propiedad)){
            if(propiedad.isEstaArrendada() == false){
                System.out.println("su propiedad " + propiedad.getIdPropiedad()+ " ahora esta disponible");
            }else{
                System.out.println("su propiedad "+ propiedad.getIdPropiedad()+ " ahora esta arrendada");
            }
        }else{
            System.out.println("la propiedad no pertenece al propietario");
        }   
    }

    public ArrayList<Propiedad> getPropiedadesPropietario() {
        return propiedadesPropietario;
    }
    

// preguntar sobre el to string 

    @Override
    public String toString() {
        return this.getNombrePersona();
    }




    public void agregarPropiedades(Propiedad propiedad){
        if (!propiedadesPropietario.contains(propiedad)) {
            propiedadesPropietario.add(propiedad);
        }
    }

    
}
