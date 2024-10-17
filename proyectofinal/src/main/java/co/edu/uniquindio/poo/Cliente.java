package co.edu.uniquindio.poo;

public class Cliente extends Persona {
    private float presupuesto;
    private Propiedad preferencia;

    public Cliente(String nombrePersona, String apellidopersona, String telefonoPersona, int edad, String idPersona,
            float presupuesto, Propiedad preferencia) {
                super(nombrePersona, apellidopersona, telefonoPersona, edad, idPersona);
                this.presupuesto = presupuesto;
                this.preferencia = preferencia;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public Propiedad getPreferencia() {
        return preferencia;
    }

  
}
