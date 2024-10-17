package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Inmobiliaria {
    private String nombreInmobiliaria;
    private String telefonoInmobiliaria;
    private String emailInmobiliaria;
    private ArrayList<Propiedad> propiedades;
    private ArrayList<ContratoArrendamientoReal> contratos;
    //atributo instancia unica
    private static Inmobiliaria instanciaUnica;

    private Inmobiliaria(String nombreInmobiliaria, String telefonoInmobiliaria, String emailInmobiliaria,
            ArrayList<Propiedad> propiedades, ArrayList<ContratoArrendamientoReal> contratos) {
        this.nombreInmobiliaria = nombreInmobiliaria;
        this.telefonoInmobiliaria = telefonoInmobiliaria;
        this.emailInmobiliaria = emailInmobiliaria;
        this.propiedades = new ArrayList<>();
        this.contratos = new ArrayList<>();
    }

    // singleton inmobilaria
    public static Inmobiliaria getInstanciaInmobiliaria(String nombreInmobiliaria, String telefonoInmobiliaria,
            String emailInmobiliaria, ArrayList<Propiedad> propiedades, ArrayList<ContratoArrendamientoReal> contratos) {
        if (instanciaUnica == null) {
            instanciaUnica = new Inmobiliaria(nombreInmobiliaria, telefonoInmobiliaria, emailInmobiliaria, propiedades,
                    contratos);
        }
        return instanciaUnica;
    }

    // metodo para agregar una propiedad a la inmobiliaria
    public void AgregarPropiedad(Propiedad propiedad) {
        // se usa el metodo .contains() para recorrer la lista y verificar que no este
        // repetido un objeto
        if (getPropiedades().contains(propiedad)) {
            getPropiedades().add(propiedad);
            System.out.println("La propiedad ya está en la lista: " + propiedad);
        } else {
            getPropiedades().add(propiedad);
            System.out.println("Propiedad agregada: " + propiedad);
        }

    }

    // metodo para eliminar la propiedad de la inmobiliaria
    public void EliminarPropiedad(Propiedad propiedad) {
        if (propiedades.contains(propiedad)) {
            getPropiedades().remove(propiedad);
            System.out.println("La propiedad " + propiedad + "ya se elimino");
        } else {
            throw new NoSuchElementException("Propiedad no encontrada: " + propiedad);
        }

    }

    // metodo para agregar un contrato a la lista
    public void AgregarContrato(ContratoArrendamientoReal contratoArrendamiento) {
        contratos.add(contratoArrendamiento);
        System.out.println("contrato agregado con exito");
    }

    // metodo para buscar contrato por la identificacion del cliente
    public ArrayList<ContratoArrendamientoReal> obtenerContratoPorCliente(String idCliente) {
        ArrayList<ContratoArrendamientoReal> resultado = new ArrayList<ContratoArrendamientoReal>();
        for (ContratoArrendamientoReal contrato : contratos) {
            if (contrato.getCliente().getIdPersona() == idCliente) {
                resultado.add(contrato);
            }
        }
        return resultado;
    }

    // metodo para liberar una propiedad cuando se termine el contrato
    public void liberarPropiedad(ContratoArrendamientoReal contratoArrendamiento, LocalDate fechaActual) {
        if (fechaActual.isAfter(contratoArrendamiento.getFechaFin())) {
            contratoArrendamiento.getPropiedad().setEstaArrendada(false);
            System.out.println("la propiedad " + contratoArrendamiento.getPropiedad() + "ha sido liberada");
        } else {
            System.out.println("el contrato esta vigente, no se puede liberar la propiedad");
        }
    }

    public String getNombreInmobiliaria() {
        return nombreInmobiliaria;
    }

    public void setNombreInmobiliaria(String nombreInmobiliaria) {
        this.nombreInmobiliaria = nombreInmobiliaria;
    }

    public String getTelefonoInmobiliaria() {
        return telefonoInmobiliaria;
    }

    public void setTelefonoInmobiliaria(String telefonoInmobiliaria) {
        this.telefonoInmobiliaria = telefonoInmobiliaria;
    }

    public String getEmailInmobiliaria() {
        return emailInmobiliaria;
    }

    public void setEmailInmobiliaria(String emailInmobiliaria) {
        this.emailInmobiliaria = emailInmobiliaria;
    }

    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public ArrayList<ContratoArrendamientoReal> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<ContratoArrendamientoReal> contratos) {
        this.contratos = contratos;
    }

    @Override
    public String toString() {
        return "Inmobiliaria [nombreInmobiliaria=" + nombreInmobiliaria + ", telefonoInmobiliaria="
                + telefonoInmobiliaria + ", emailInmobiliaria=" + emailInmobiliaria + ", propiedades=" + propiedades
                + ", contratos=" + contratos + "]";
    }

}
