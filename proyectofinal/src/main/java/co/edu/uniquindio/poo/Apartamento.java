package co.edu.uniquindio.poo;


public class Apartamento extends Propiedad  {
    private float valorAdministracion;

    public Apartamento(String localizacion, String descripcion, String idPropiedad, float valorArriendo,
    float valorDeposito, Propietario propietario, boolean estaArrendada, float comision) {
        super(localizacion, descripcion, idPropiedad, valorArriendo, valorDeposito, propietario, estaArrendada,
        comision);
        
    }

    @Override
    public String getIdPropiedad() {
        return super.getIdPropiedad();
    }

    public float getValorAdministracion() {
        return valorAdministracion;
    }

    public void setValorAdministracion(float valorAdministracion) {
        this.valorAdministracion = valorAdministracion;
    }

    @Override
    public int definirEstrato() {
        if (getValorAdministracion() <= 150000) {
            System.out.println("el apartamento es estrato 4");
            return 4;

        } else {
            System.out.println("el apartamento es estrato 5");
            return 5;
        }
    }

    @Override
    public String getDescripcion(){
        return "apartamento basico";
    }


}
