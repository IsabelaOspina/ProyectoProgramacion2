package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.poo.Builder.AgenteBuilder;
import co.edu.uniquindio.poo.Builder.ContadorBuilder;
import co.edu.uniquindio.poo.Composite.ConjuntoPropiedad;
import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Decorator.ConParqueadero;
import co.edu.uniquindio.poo.Factory.PropiedadFactory;
import co.edu.uniquindio.poo.Proxy.ContratoArrendamientoProxy;

public class App {
        public static void main(String[] args) {


                ArrayList <Propiedad> propiedadesPropietario=new ArrayList<>();

                // lista propiedades de la inmobiliaria
                ArrayList<Propiedad> listapropiedades = new ArrayList<Propiedad>();
                
                // lista de contratos
                ArrayList<ContratoArrendamientoReal> listaContrato = new ArrayList<ContratoArrendamientoReal>();

                // lista de ingresos y egresos
                ArrayList<Float> listaingresos = new ArrayList<>();
                ArrayList<Float> listaegresos = new ArrayList<>();

                // registro contable
                RegistroContable registroContable = RegistroContable.getInstaciaRegistroContable(listaingresos, listaegresos);

                // propietario
                Propietario propietario = new Propietario("isabela", "ospina", "32415273", 21, "12345",
                                propiedadesPropietario);
                

                // propiedades
               
                PropiedadFactory factory = new PropiedadFactory();
                Casa propiedad1=(Casa) factory.crearPropiedad("casa","sur", "grande", "123", 100000, 1234, propietario, true, 10000 );
                propiedad1.setNumeroPisos(1);

                propietario.agregarPropiedades(propiedad1);

                PropiedadFactory factory2 = new PropiedadFactory();
                Apartamento propiedad2= (Apartamento) factory2.crearPropiedad("apartamento","norte", "edificio torre 2", "234", 1500000, 200000, propietario,false,30000);
                propiedad2.setValorAdministracion(1000);


                
                // cliente

                Cliente cliente = new Cliente("pepe", "perez", "311245844", 67, "290098", 10000000, propiedad1);
                Cliente cliente2 = new Cliente("juanita", "lopez", "311844", 20, "290", 10000000, propiedad2);
                
                // inmobiliaria
                Inmobiliaria inmobiliaria = Inmobiliaria.getInstanciaInmobiliaria("inmobiliaria ", "31378549",
                                "inmobiliaria@gmail.com", listapropiedades, listaContrato);
                System.out.println(inmobiliaria);

                // agente inmobiliario
                AgenteInmobiliario agente = new AgenteInmobiliario("pablo", "perez", "30459609", 30, "12555", 1000000,
                                listapropiedades, cliente);

                // contador
                Contador contador = new Contador("juan", "rodriguez", "325475964", 43, "6789076", 2500000,
                                registroContable);

                // prueba metodos agregar propiedad
                inmobiliaria.AgregarPropiedad(propiedad2);
                inmobiliaria.AgregarPropiedad(propiedad1);
                // inmobiliaria.EliminarPropiedad(propiedad2);
                agente.ArrendarPropiedad(propiedad2, cliente);
                agente.ArrendarPropiedad(propiedad1, cliente);
                System.out.println(propiedad1.isEstaArrendada());
                System.out.println(propiedad2.isEstaArrendada());

                // System.out.println(listapropiedades)
                agente.ArrendarPropiedad(propiedad1, cliente);
                agente.ArrendarPropiedad(propiedad2, cliente);
                AgenteInmobiliario agente2 = new AgenteBuilder()
                        .setNombreAgente("Hola")
                        .setApellidoAgente("Adios")
                        .builderAgente();
                System.out.println(agente2.toString());

                Contador contador2= new ContadorBuilder()
                        .setApellidoContador(null)
                        .builderContador();

                // prueba del metodo calcular sueldo final
                System.out.println("el sueldo final del agente es de " + contador.calcularSueldoFinal(agente));

                // prueba del metodo calcular valor final de la propiedad
                System.out.println("el valor final del apartamento es de : "
                                + agente.calcularValorFinalPropiedad(propiedad2));

                // prueba metodo generar contrato arrendamiento
                ContratoArrendamientoReal contrato = new ContratoArrendamientoReal(propiedad2, cliente, agente,
                                LocalDate.of(2024, 01, 01), LocalDate.of(2024, 06, 01));
                ContratoArrendamientoProxy proxy = new ContratoArrendamientoProxy(contrato,agente);
                System.out.println(proxy.obtenerInformacionContrato());

                ContratoArrendamientoReal contrato2 = new ContratoArrendamientoReal(propiedad1, cliente2, agente,
                                LocalDate.of(2024, 01, 01), LocalDate.of(2024, 10, 01));

                agente.generContratoArrendamiento(propiedad2, cliente, agente,
                                LocalDate.of(2024, 01, 01), LocalDate.of(2024, 06, 01));

                agente.generContratoArrendamiento(propiedad1, cliente2, agente,
                                LocalDate.of(2024, 01, 01), LocalDate.of(2024, 10, 01));

                System.out.println(contrato.obtenerInformacionContrato());
                System.out.println(contrato2.obtenerInformacionContrato());

                //prueba metodo agregar contarto a la lista
                inmobiliaria.AgregarContrato(contrato);
                inmobiliaria.AgregarContrato(contrato2);

                // prueba metodo para obtener contrato por id del cliente
                System.out.println(inmobiliaria.obtenerContratoPorCliente("290"));

                // prueba para metodo de ingresos y egresos

                contador.registrarEgreso(contador.getSueldoContador());
                contador.registrarIngreso(propiedad1.getValorArriendo());

                // prueba metodo calcular renta total
                long rentaTotal = contador.calcularRentaTotal(contrato2);
                contador.ingresoRenta(rentaTotal);
                System.out.println(listaingresos);

                // prueba metodo para liberar propiedad
                inmobiliaria.liberarPropiedad(contrato2, LocalDate.of(2024, 10, 02));

                //prueba metodo agregar propiedad a un conjunto de propiedades
                ConjuntoPropiedad conjuntoCasa=new ConjuntoPropiedad("conjunto de casas");
                conjuntoCasa.agregarPropiedadAlConjunto(propiedad1);
                //conjuntoCasa.agregarPropiedadAlConjunto(propiedad1);

                //prueba decoradores
                //propiedad1=new ConParqueadero(propiedad1);
                System.out.println(propiedad1.getDescripcion());

                //prueba metodo para calcular valor total renta del conjunto de propiedades
                float rentaConjunto= conjuntoCasa.rentaTotalConjunto(agente);
                System.out.println(rentaConjunto);


                //prueba metodo definir estrato de un conjunto
                System.out.println("estrato del conjunto "+ conjuntoCasa.definirEstrato());
                
                Componente propiedadDecorada=new ConParqueadero(propiedad1);
                System.out.println(propiedadDecorada.getDescripcion());

                //prueba patron observer
                //propiedad1.agregarObservadores(agente2);
                propiedad1.agregarObservadores(propietario);
                propiedad1.setEstaArrendada(false);

                
        }

}
 