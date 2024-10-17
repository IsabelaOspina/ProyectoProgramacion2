package co.edu.uniquindio.poo;
import java.time.LocalDate;

public class Factura {
    private long numeroFactura;
    private float valorPago;
    private LocalDate fechaGenerado;
    private LocalDate fechaVencimiento;
    private EstadoTransaccion estadoTransaccion;
    private Cliente clienteFactura;
    

    public Factura(long numeroFactura, float valorPago, LocalDate fechaGenerado, LocalDate fechaVencimiento,
            EstadoTransaccion estadoTransaccion, Cliente clientefactura) {
        this.numeroFactura = numeroFactura;
        this.valorPago = valorPago;
        this.fechaGenerado = fechaGenerado;
        this.fechaVencimiento = fechaVencimiento;
        this.estadoTransaccion = estadoTransaccion;
        this.clienteFactura=clientefactura;
    }

    // metodo para generar comprobate de pago
    public String generarComprobante(){
        return "COMPROBANTE DE PAGO \n\n"+
                "numero de factura: "+numeroFactura + "\n"+
                "valor pagado: "+ valorPago+ "\n" +
                "fecha de pago: " + fechaGenerado + "\n" +
                "estado de transaccion: " + estadoTransaccion + "\n"+
                "cliente: " + clienteFactura.getIdPersona() + "\n";
                
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getFechaGenerado() {
        return fechaGenerado;
    }

    public void setFechaGenerado(LocalDate fechaGenerado) {
        this.fechaGenerado = fechaGenerado;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EstadoTransaccion getEstadoTransaccion() {
        return estadoTransaccion;
    }

    public void setEstadoTransaccion(EstadoTransaccion estadoTransaccion) {
        this.estadoTransaccion = estadoTransaccion;
    }

    public Cliente getClienteFactura() {
        return clienteFactura;
    }

    public void setClienteFactura(Cliente clienteFactura) {
        this.clienteFactura = clienteFactura;
    }

   
}
