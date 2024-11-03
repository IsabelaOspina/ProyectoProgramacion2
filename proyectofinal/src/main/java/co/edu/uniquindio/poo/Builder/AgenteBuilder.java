package co.edu.uniquindio.poo.Builder;

import co.edu.uniquindio.poo.AgenteInmobiliario;
import co.edu.uniquindio.poo.Cliente;
import co.edu.uniquindio.poo.Propiedad;
import java.util.ArrayList;

public class AgenteBuilder {
    private String nombreAgente;
    private String apellidoAgente;
    private String telefonoAgente;
    private int edadAgente;
    private String idAgente;
    private float sueldoMinimo;
    private ArrayList<Propiedad> propiedadesArrendadas;
    private ArrayList<Cliente> clientes;

    public AgenteBuilder setNombreAgente(String nombreAgente) {
        this.nombreAgente = nombreAgente;
        return this;
    }

    public AgenteBuilder setApellidoAgente(String apellidoAgente) {
        this.apellidoAgente = apellidoAgente;
        return this;
    }

    public AgenteBuilder setTelefonoAgente(String telefonoAgente) {
        this.telefonoAgente = telefonoAgente;
        return this;
    }

    public AgenteBuilder setEdadAgente(int edadAgente) {
        this.edadAgente = edadAgente;
        return this;
    }

    public AgenteBuilder setIdAgente(String idAgente) {
        this.idAgente = idAgente;
        return this;
    }

    public AgenteBuilder setSueldoMinimo(float sueldoMinimo) {
        this.sueldoMinimo = sueldoMinimo;
        return this;
    }

    public AgenteBuilder setPropiedadesArrendadas(ArrayList<Propiedad> propiedadesArrendadas) {
        this.propiedadesArrendadas = propiedadesArrendadas;
        return this;
    }

    public AgenteBuilder setCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
        return this;
    }

    // metodo builder para agente inmobiliario
    public AgenteInmobiliario builderAgente() {
        return new AgenteInmobiliario(this.telefonoAgente, this.nombreAgente, this.idAgente, this.edadAgente,
                this.apellidoAgente, this.sueldoMinimo, this.propiedadesArrendadas, this.clientes);
    }

}
