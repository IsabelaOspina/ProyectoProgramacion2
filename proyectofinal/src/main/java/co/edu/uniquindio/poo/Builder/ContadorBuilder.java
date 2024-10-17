package co.edu.uniquindio.poo.Builder;

import co.edu.uniquindio.poo.Contador;
import co.edu.uniquindio.poo.RegistroContable;

public class ContadorBuilder {
    private String nombreContador;
    private String apellidoContador;
    private String telefonoContador;
    private int edadContador;
    private String idContador;
    private float sueldoContador;
    private RegistroContable registroContable;

    public ContadorBuilder setNombreContador(String nombreContador) {
        this.nombreContador = nombreContador;
        return this;
    }

    public ContadorBuilder setApellidoContador(String apellidoContador) {
        this.apellidoContador = apellidoContador;
        return this;
    }

    public ContadorBuilder setTelefonoContador(String telefonoContador) {
        this.telefonoContador = telefonoContador;
        return this;
    }

    public ContadorBuilder setEdadContador(int edadContador) {
        this.edadContador = edadContador;
        return this;
    }

    public ContadorBuilder setIdContador(String idContador) {
        this.idContador = idContador;
        return this;
    }

    public ContadorBuilder setSueldoContador(float sueldoContador) {
        this.sueldoContador = sueldoContador;
        return this;
    }

    public ContadorBuilder setRegistroContable(RegistroContable registroContable) {
        this.registroContable = registroContable;
        return this;
    }

    //metodo builder para contador
    public Contador builderContador() {
        return new Contador(this.telefonoContador, this.nombreContador, this.idContador, this.edadContador,
                this.apellidoContador, this.sueldoContador, this.registroContable);
    }

}
