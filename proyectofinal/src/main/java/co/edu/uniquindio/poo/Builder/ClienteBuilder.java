package co.edu.uniquindio.poo.Builder;

import co.edu.uniquindio.poo.Cliente;
import co.edu.uniquindio.poo.Propiedad;

public class ClienteBuilder {
    private String nombreCliente;
    private String apellidoCliente;
    private String telefonoCliente;
    private int edadCliente;
    private String idCliente;
    private float presupuestoCliente;
    private Propiedad preferenciaCliente;

    

    public ClienteBuilder setNombreCliente(String nombreCliente){
        this.nombreCliente=nombreCliente;
        return this;
    }

    public ClienteBuilder setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
        return this;
    }

    public  ClienteBuilder setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
        return this;
    }

    public ClienteBuilder setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
        return this;
    }

    public ClienteBuilder setIdCliente(String idCliente) {
        this.idCliente = idCliente;
        return this;
    }
    public ClienteBuilder setPreferenciaCliente(Propiedad preferenciaCliente) {
        this.preferenciaCliente=preferenciaCliente;
        return this;
    }
    public ClienteBuilder setPresupuestoCliente(float presupuestoCliente) {
        this.presupuestoCliente=presupuestoCliente;
        return this;
    }

    //metodo builder para cliente
    public Cliente builderCliente(){
        return new Cliente(this.nombreCliente, this.apellidoCliente, this.telefonoCliente, this.edadCliente, this.idCliente, this.presupuestoCliente, this.preferenciaCliente);
    }    
}
