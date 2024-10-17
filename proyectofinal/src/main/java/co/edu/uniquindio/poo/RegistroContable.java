package co.edu.uniquindio.poo;

import java.util.ArrayList;

public class RegistroContable {
    private ArrayList<Float> ingresos;
    private ArrayList<Float> egresos;
    //atributo estatico instancia unica
    private static RegistroContable registroContableUnico;


    private RegistroContable(ArrayList<Float> ingresos, ArrayList<Float> egresos) {
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    //singleton registro contable
    public static RegistroContable getInstaciaRegistroContable(ArrayList<Float> ingresos, ArrayList<Float> egresos){
        if(registroContableUnico==null){
            registroContableUnico=new RegistroContable(ingresos, egresos);
        }
        return registroContableUnico;
    }

    // metodo para agregar ingreso
    public void agregarIngreso(float ingreso){
        ingresos.add(ingreso);
    }

    // metodo para agregar egreso
    public void agregarEgreso(float egreso){
        egresos.add(egreso);
    }

    
    public ArrayList<Float> getIngresos() {
        return ingresos;
    }

    public void setIngresos(ArrayList<Float> ingresos) {
        this.ingresos = ingresos;
    }

    public ArrayList<Float> getEgresos() {
        return egresos;
    }

    public void setEgresos(ArrayList<Float> egresos) {
        this.egresos = egresos;
    }



    
}
