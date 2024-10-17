package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class Propietario extends Persona {
    private ArrayList <Propiedad> propiedadesPropietario;

    public Propietario(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            ArrayList<Propiedad> propiedadesPropietario) {
                super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
        this.propiedadesPropietario=new ArrayList<>();
        
    }

    public ArrayList<Propiedad> getPropiedadesPropietario() {
        return propiedadesPropietario;
    }


    @Override
    public String toString() {
        return "Propietario [propiedadesPropietario=" + propiedadesPropietario + "]";
    }

    
}
