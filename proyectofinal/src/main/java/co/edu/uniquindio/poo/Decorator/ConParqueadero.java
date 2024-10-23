package co.edu.uniquindio.poo.Decorator;



public  class ConParqueadero extends DecoradorPropiedad{

    public ConParqueadero(Componente propiedadBase) {
        super(propiedadBase);
    }
    @Override
    public String getDescripcion(){
        return propiedadBase.getDescripcion() + ", con parqueadero";
    }
    
}
