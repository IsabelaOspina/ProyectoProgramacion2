package co.edu.uniquindio.poo;



public class Local extends Propiedad {
    private float espacioBodega;

    public Local(String localizacion, String descripcion, String idPropiedad, float valorArriendo, float valorDeposito,
            Propietario propietario, boolean estaArrendada,float comision) {
        super(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada,comision);
        
    }

    @Override
    public String getIdPropiedad() {
        return super.getIdPropiedad();
    }

    @Override
    public String getDescripcion(){
        return "local basico ";

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
