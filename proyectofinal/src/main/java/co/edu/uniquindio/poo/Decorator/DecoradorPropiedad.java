package co.edu.uniquindio.poo.Decorator;


public abstract class DecoradorPropiedad implements Componente {
    protected Componente propiedadBase;

    public DecoradorPropiedad(Componente propiedadBase) {
        this.propiedadBase = propiedadBase;
    }

    @Override
    public abstract String getDescripcion();
    
}
