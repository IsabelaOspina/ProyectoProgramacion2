package co.edu.uniquindio.poo.Decorator;

public class ConAireAcondicionado extends DecoradorPropiedad{
    public ConAireAcondicionado(PropiedadBase propiedadBase) {
        super(propiedadBase);
    }
    @Override
    public String getDescripcion(){
        return propiedadBase.getDescripcion() + ", con parqueadero";
    }
    
    
}
