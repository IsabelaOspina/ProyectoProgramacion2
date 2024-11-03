package co.edu.uniquindio.poo.Decorator;

public class ConAireAcondicionado extends DecoradorPropiedad{
    public ConAireAcondicionado(Componente propiedadBase) {
        super(propiedadBase);
    }
    @Override
    public String getDescripcion(){
        return propiedadBase.getDescripcion() + ", con aire acondicionado";
    }
    
    
}
