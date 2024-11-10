package co.edu.uniquindio.poo;

import java.time.LocalDate;

import co.edu.uniquindio.poo.Proxy.IContrato;

public class ContratoArrendamientoReal implements IContrato {
    private Propiedad propiedad;
    private Cliente cliente;
    private AgenteInmobiliario agenteInmobiliario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double valorFinal;

    public ContratoArrendamientoReal(Propiedad propiedad, Cliente cliente, AgenteInmobiliario agenteInmobiliario,
            LocalDate fechaInicio, LocalDate fechaFin) {
        this.propiedad = propiedad;
        this.cliente = cliente;
        this.agenteInmobiliario = agenteInmobiliario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.valorFinal=agenteInmobiliario.calcularValorFinalPropiedad(propiedad);
    }

    // metodo para obtener informacion del contrato
    @Override
    public String obtenerInformacionContrato() {
        return "CONTRATO DE ARRENDAMIENTO\n\n" +
                "Propiedad: " + this.propiedad.getLocalizacion() + "\n" +
                "Agente Inmobiliario: " + this.agenteInmobiliario.getNombrePersona() + "\n" +
                "Arrendatario: " + this.propiedad.getPropietario().getNombrePersona() + "\n" +
                "Fecha de inicio: " + this.fechaInicio + "\n" +
                "Fecha de fin: " + this.fechaFin + "\n" +
                "Monto mensual de la renta: $" + this.valorFinal + "\n";

    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AgenteInmobiliario getAgenteInmobiliario() {
        return agenteInmobiliario;
    }

    public void setAgenteInmobiliario(AgenteInmobiliario agenteInmobiliario) {
        this.agenteInmobiliario = agenteInmobiliario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
    public int getMes() {
        return this.fechaInicio.getMonthValue();
    }

    public int getAño() {
        return this.fechaInicio.getYear();
    }

}
