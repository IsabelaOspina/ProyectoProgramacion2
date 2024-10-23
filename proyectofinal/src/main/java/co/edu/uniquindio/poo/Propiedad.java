package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Factory.IPropiedad;

public abstract class Propiedad implements Componente, IPropiedad{
    private String localizacion;
    private String descripcion;
    private String idPropiedad;
    private float valorArriendo;
    private float valorDeposito;
    private Propietario propietario;
    private boolean estaArrendada;
    private float comision;

    public Propiedad(String localizacion, String descripcion, String idPropiedad, float valorArriendo,
            float valorDeposito, Propietario propietario, boolean estaArrendada,float comision) {
        this.localizacion = localizacion;
        this.descripcion = descripcion;
        this.idPropiedad = idPropiedad;
        this.valorArriendo = valorArriendo;
        this.valorDeposito = valorDeposito;
        this.propietario = propietario;
        this.estaArrendada= estaArrendada;
        this.comision=comision;
    }

    @Override
    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public abstract int definirEstrato();

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDescripcionPropiedad() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(String idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public float getValorArriendo() {
        return valorArriendo;
    }

    public void setValorArriendo(float valorArriendo) {
        this.valorArriendo = valorArriendo;
    }

    public float getValorDeposito() {
        return valorDeposito;
    }

    public void setValorDeposito(float valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public boolean isEstaArrendada() {
        return estaArrendada;
    }

    public void setEstaArrendada(boolean estaArrendada) {
        this.estaArrendada = estaArrendada;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Propiedad [localizacion=" + localizacion + ", descripcion=" + descripcion + ", idPropiedad="
                + idPropiedad + ", valorArriendo=" + valorArriendo + ", valorDeposito=" + valorDeposito
                + ", propietario=" + propietario + ", estaArrendada=" + estaArrendada + ", comision=" + comision + "]";
    }

       
}
