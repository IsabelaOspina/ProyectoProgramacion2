package co.edu.uniquindio.poo.Builder;

import co.edu.uniquindio.poo.Propiedad;
import co.edu.uniquindio.poo.Propietario;

import java.util.ArrayList;

public class PropietarioBuilder {
    private String nombrePropietario;
    private String apellidoPropietario;
    private String telefonoPropietario;
    private int edadPropietario;
    private String idPropietario;
    private ArrayList<Propiedad> propiedadesPropietario;

    public PropietarioBuilder setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
        return this;
    }

    public PropietarioBuilder setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
        return this;
    }

    public PropietarioBuilder setTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
        return this;
    }

    public PropietarioBuilder setEdadPropietario(int edadPropietario) {
        this.edadPropietario = edadPropietario;
        return this;
    }

    public PropietarioBuilder setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
        return this;
    }

    public PropietarioBuilder setPropiedadesPropietario(ArrayList<Propiedad> propiedadesPropietario) {
        this.propiedadesPropietario = propiedadesPropietario;
        return this;
    }

    // metodo builder para propietario
    public Propietario builderPropietario() {
        return new Propietario(this.nombrePropietario, this.apellidoPropietario, this.telefonoPropietario,
                this.edadPropietario,
                this.idPropietario, this.propiedadesPropietario);

    }

}
