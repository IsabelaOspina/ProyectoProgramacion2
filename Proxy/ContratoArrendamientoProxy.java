package co.edu.uniquindio.poo.Proxy;

import co.edu.uniquindio.poo.AgenteInmobiliario;
import co.edu.uniquindio.poo.ContratoArrendamientoReal;
import co.edu.uniquindio.poo.Persona;

public class ContratoArrendamientoProxy implements IContrato {
    private ContratoArrendamientoReal contratoArrendamientoReal;
    private Persona persona;

    public ContratoArrendamientoProxy(ContratoArrendamientoReal contratoArrendamientoReal, Persona persona) {
        this.contratoArrendamientoReal=contratoArrendamientoReal;
        this.persona = persona; 
    }

    @Override
    public String obtenerInformacionContrato() {
        System.out.println(persona.getClass());
        if (this.persona instanceof AgenteInmobiliario) {
            return contratoArrendamientoReal.obtenerInformacionContrato();
        } else {
            return "Error de permisos";
        }
    }
}
