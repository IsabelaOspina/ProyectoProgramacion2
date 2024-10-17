package co.edu.uniquindio.poo;

public class Persona {
    private String nombrePersona;
    private String apellidopersona;
    private String telefonoPersona;
    private int edad;
    private String idPersona;

    public Persona(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidopersona = apellidopersona;
        this.telefonoPersona = telefonoPersona;
        this.edad = edad;
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public String getApellidopersona() {
        return apellidopersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }


    public int getEdad() {
        return edad;
    }

    public String getIdPersona() {
        return idPersona;
    }



    
}
