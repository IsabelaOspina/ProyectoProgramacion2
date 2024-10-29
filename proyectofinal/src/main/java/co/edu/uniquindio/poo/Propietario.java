package co.edu.uniquindio.poo;

import java.util.ArrayList;

import co.edu.uniquindio.poo.Observer.Observador;

public class Propietario extends Persona implements Observador{
    private ArrayList <Propiedad> propiedadesPropietario=new ArrayList<>();

    public Propietario(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            ArrayList<Propiedad> propiedadesPropietario) {
                super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
        this.propiedadesPropietario=propiedadesPropietario;
        
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
        }    
    }

    public ArrayList<Propiedad> getPropiedadesPropietario() {
        return propiedadesPropietario;
    }


    @Override
    public String toString() {
        return "Propietario [propiedadesPropietario=" + propiedadesPropietario + "]";
    }

    public void agregarPropiedades(Propiedad propiedad){
        propiedadesPropietario.add(propiedad);
    }

    
}
