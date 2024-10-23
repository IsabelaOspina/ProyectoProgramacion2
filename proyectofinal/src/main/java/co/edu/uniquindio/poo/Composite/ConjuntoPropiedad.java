package co.edu.uniquindio.poo.Composite;
import java.util.ArrayList;

import co.edu.uniquindio.poo.AgenteInmobiliario;
import co.edu.uniquindio.poo.Propiedad;
import co.edu.uniquindio.poo.Factory.IPropiedad;

public class ConjuntoPropiedad implements IPropiedad{
    private String nombreConjunto;
    private ArrayList<IPropiedad>  propiedadesConjunto;
    private Object tipoPropiedad;

    public ConjuntoPropiedad(String nombreConjunto) {
        this.nombreConjunto = nombreConjunto;
        propiedadesConjunto=new ArrayList<>();

        
    }

    //metodo para agregar propiedad al conjunto
    public void agregarPropiedadAlConjunto(IPropiedad propiedad){
        if(tipoPropiedad==null){
            tipoPropiedad=propiedad.getClass();
            System.out.println("la propiedad "+((Propiedad) propiedad).getIdPropiedad()+" a "+ nombreConjunto);
        }else{
            if(tipoPropiedad.getClass()== propiedad.getClass()){
                propiedadesConjunto.add(propiedad);
                System.out.println("la propiedad "+ ((Propiedad) propiedad).getIdPropiedad()+ " a "+ nombreConjunto);
            }else{
                System.out.println("error, solo se admiten propiedades del tipo "+getTipoPropiedad());
            }
        }
    }

    @Override
    public int definirEstrato(){
        int estratoConjunto=0;
        for (IPropiedad propiedad:propiedadesConjunto){
            estratoConjunto += propiedad.definirEstrato();
        }
        return estratoConjunto/propiedadesConjunto.size();
    }

    //metodo para definir la renta total del conjunto
    public float rentaTotalConjunto(AgenteInmobiliario agente){
        float rentaTotalConjunto=0;
        for(IPropiedad propiedad:propiedadesConjunto){
            rentaTotalConjunto += agente.calcularValorFinalPropiedad((Propiedad)propiedad);
        }
        return rentaTotalConjunto;
    }

    public String getNombreConjunto() {
        return nombreConjunto;
    }

    public void setNombreConjunto(String nombreConjunto) {
        this.nombreConjunto = nombreConjunto;
    }

    public ArrayList<IPropiedad> getPropiedadesConjunto() {
        return propiedadesConjunto;
    }

    public void setPropiedadesConjunto(ArrayList<IPropiedad> propiedadesConjunto) {
        this.propiedadesConjunto = propiedadesConjunto;
    }

    public Object getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(Object tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }



    
}
