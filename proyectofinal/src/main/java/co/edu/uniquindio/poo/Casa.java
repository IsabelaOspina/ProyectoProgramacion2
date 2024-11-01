package co.edu.uniquindio.poo;


public class Casa extends Propiedad {
    private int numeroPisos;

    public Casa(String localizacion, String descripcion, String idPropiedad, float valorArriendo, float valorDeposito,
            Propietario propietario, boolean estaArrendada,float comision) {
        super(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario,estaArrendada,comision);
        
    }
    

    @Override
    public String getIdPropiedad() {
        return super.getIdPropiedad();
    }
    


    @Override
    public String getDescripcion(){
        return "casa basica";
    }



    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    @Override
    public int definirEstrato(){
        if(getLocalizacion()=="sur".toLowerCase()){
            System.out.println("la casa es estrato 1");
            return 1;
           
    
        }else if(getLocalizacion()=="centro".toLowerCase()){
            System.out.println("la casa es estrato 2");
            return 2;
            
        }else{
            System.out.println("la casa es estrato 3");
            return 3;
        }
           
        
    }
    



    
}
