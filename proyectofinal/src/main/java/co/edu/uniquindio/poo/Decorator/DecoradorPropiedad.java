package co.edu.uniquindio.poo.Decorator;


public abstract class DecoradorPropiedad implements PropiedadBase {
    protected PropiedadBase propiedadBase;

    public DecoradorPropiedad(PropiedadBase propiedadBase) {
        this.propiedadBase = propiedadBase;
    }

    @Override
    public abstract String getDescripcion();
    
}
