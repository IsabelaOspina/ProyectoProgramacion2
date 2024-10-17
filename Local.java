package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.Factory.IPropiedad;

import co.edu.uniquindio.poo.Decorator.PropiedadBase;

public class Local extends Propiedad implements IPropiedad, PropiedadBase{
    private float espacioBodega;

    public Local(String localizacion, String descripcion, String idPropiedad, float valorArriendo, float valorDeposito,
            Propietario propietario, boolean estaArrendada,float comision) {
        super(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada,comision);
        
    }

    @Override
    public String getIdPropiedad() {
        // TODO Auto-generated method stub
        return super.getIdPropiedad();
    }

    @Override
    public String getDescripcion(){
        return "local "+ getDescripcionPropiedad();

    }

    public float getEspacioBodega() {
        return espacioBodega;
    }

    public void setEspacioBodega(float espacioBodega) {
        this.espacioBodega = espacioBodega;
    }

    @Override
    public int definirEstrato(){
        if(getEspacioBodega()<= 50){
            System.out.println("el local es estrato 3");
            return 3;

        }else{
            System.out.println("el local es estrato 4");
            return 4;
        }
    }

    
}
