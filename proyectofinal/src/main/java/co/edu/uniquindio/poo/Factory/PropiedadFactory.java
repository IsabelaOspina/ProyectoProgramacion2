package co.edu.uniquindio.poo.Factory;

import co.edu.uniquindio.poo.Propiedad;
import co.edu.uniquindio.poo.Propietario;
import co.edu.uniquindio.poo.Apartamento;
import co.edu.uniquindio.poo.Casa;
import co.edu.uniquindio.poo.Local;

public class PropiedadFactory {

    //metodo para crear propiedad
    public Propiedad crearPropiedad(String tipo,String localizacion, String descripcion, String idPropiedad, float valorArriendo, float valorDeposito,
            Propietario propietario, boolean estaArrendada,float comision){
        switch (tipo.toLowerCase()) {
            case "apartamento":
                return new Apartamento(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada, comision);
            
            case "local":
                return new Local(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada,comision);

            case "casa":
                return new Casa(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada,comision);
            default:
                throw new IllegalArgumentException("la propiedad no es compatible");
        }
    } 
    
}
