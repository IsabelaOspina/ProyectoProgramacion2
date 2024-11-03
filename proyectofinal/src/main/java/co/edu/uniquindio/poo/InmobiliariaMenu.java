package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uniquindio.poo.Builder.ContadorBuilder;
import co.edu.uniquindio.poo.Builder.AgenteBuilder;
import co.edu.uniquindio.poo.Builder.ClienteBuilder;
import co.edu.uniquindio.poo.Builder.PropietarioBuilder;
import co.edu.uniquindio.poo.Factory.PropiedadFactory;

public class InmobiliariaMenu {

    public static void main(String[] args) {

        ArrayList<Propiedad> listapropiedades = new ArrayList<Propiedad>();
        ArrayList<ContratoArrendamientoReal> listaContrato = new ArrayList<ContratoArrendamientoReal>();
        ArrayList<Float> listaingresos = new ArrayList<>();
        ArrayList<Float> listaegresos = new ArrayList<>();
        AgenteInmobiliario agente = new AgenteBuilder()
                .setNombreAgente("Juan")
                .setApellidoAgente("Perez")
                .setTelefonoAgente("311245844")
                .setEdadAgente(67)
                .setIdAgente("123")
                .setSueldoMinimo(1000000)
                .setPropiedadesArrendadas(new ArrayList<>())
                .builderAgente();

        Contador contador = new ContadorBuilder()
                .setNombreContador("Pedro")
                .setApellidoContador("Gomez")
                .setTelefonoContador("311245844")
                .setEdadContador(67)
                .setIdContador("123")
                .setSueldoContador(10000)
                .builderContador();

        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        Inmobiliaria inmobiliaria = Inmobiliaria.getInstanciaInmobiliaria("Inmobiliaria programacion", "123",
                "contacto@inmobiliaria.com", listapropiedades, listaContrato);

        do {
            System.out.println("\n--- INMOBILIARIA PROGRAMACION ---");
            System.out.println("1. Agregar propiedad");
            System.out.println("2. eliminar propiedad");
            System.out.println("3. arrendar propiedad");
            System.out.println("4. obtener contrato por cliente");
            System.out.println("5. liberar propiedad");
            System.out.println("6. obtener finanzas de la inmobiliaria");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcionPrincipal = scanner.nextInt();
            scanner.nextLine();
            switch (opcionPrincipal) {

                // caso 1
                case 1: {
                    System.out.println("Tipo de propiedad (casa/apartamento/local): ");
                    String tipoPropiedad = scanner.nextLine().toLowerCase();

                    System.out.println("Ingrese la localización de la propiedad: ");
                    String localizacion = scanner.nextLine();

                    System.out.println("Ingrese la descripción de la propiedad: ");
                    String descripcion = scanner.nextLine();

                    System.out.println("Ingrese el ID de la propiedad: ");
                    String idPropiedad = scanner.nextLine();

                    System.out.println("Ingrese el valor de arriendo de la propiedad: ");
                    float valorArriendo = scanner.nextFloat();

                    System.out.println("Ingrese el valor del depósito de la propiedad: ");
                    float valorDeposito = scanner.nextFloat();

                    System.out.println("Ingrese la comisión de la propiedad: ");
                    float comision = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Ingrese el nombre del propietario de la propiedad: ");
                    String nombrePropietario = scanner.nextLine();

                    System.out.println("Ingrese el apellido del propietario de la propiedad: ");
                    String apellidoPropietario = scanner.nextLine();

                    System.out.println("Ingrese el teléfono del propietario de la propiedad: ");
                    String telefonoPropietario = scanner.nextLine();

                    System.out.println("Ingrese la edad del propietario de la propiedad: ");
                    int edadPropietario = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Ingrese el ID del propietario de la propiedad: ");
                    String idPropietario = scanner.nextLine();

                    Propietario propietario = new PropietarioBuilder()
                            .setNombrePropietario(nombrePropietario)
                            .setApellidoPropietario(apellidoPropietario)
                            .setTelefonoPropietario(telefonoPropietario)
                            .setEdadPropietario(edadPropietario)
                            .setIdPropietario(idPropietario)
                            .setPropiedadesPropietario(new ArrayList<>())
                            .builderPropietario();

                    Propiedad nuevaPropiedad = null;
                    PropiedadFactory factory = new PropiedadFactory();

                    switch (tipoPropiedad) {
                        case "casa": {
                            System.out.println("Ingrese el número de pisos: ");
                            int numeroPisos = scanner.nextInt();
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            ((Casa) nuevaPropiedad).setNumeroPisos(numeroPisos);
                            break;
                        }
                        case "apartamento": {
                            System.out.println("Ingrese el valor de administración: ");
                            float valorAdministracion = scanner.nextFloat();
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            ((Apartamento) nuevaPropiedad).setValorAdministracion(valorAdministracion);
                            break;
                        }
                        case "local": {
                            // Agregar atributos específicos de Local si los hay
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            break;
                        }
                        default: {
                            System.out.println("Tipo de propiedad no válido.");
                            break;
                        }
                    }

                    if (nuevaPropiedad != null) {
                        propietario.agregarPropiedades(nuevaPropiedad);
                        inmobiliaria.AgregarPropiedad(nuevaPropiedad);
                        listapropiedades.add(nuevaPropiedad);
                        System.out.println("Propiedad agregada exitosamente: " + nuevaPropiedad);
                    }
                    break;
                }

                // caso 2
                case 2: {
                    System.out.println("Ingrese el ID de la propiedad a eliminar: ");
                    String idPropiedadEliminar = scanner.nextLine();

                    Propiedad propiedadAEliminar = null;
                    for (Propiedad propiedad : inmobiliaria.getPropiedades()) {
                        if (propiedad.getIdPropiedad().equals(idPropiedadEliminar)) {
                            propiedadAEliminar = propiedad;
                            break;
                        }
                    }

                    if (propiedadAEliminar != null) {
                        inmobiliaria.EliminarPropiedad(propiedadAEliminar);
                        System.out.println("Propiedad eliminada exitosamente: " + propiedadAEliminar);
                    } else {
                        System.out.println("Propiedad con ID " + idPropiedadEliminar + " no encontrada.");
                    }
                    break;
                }

                // caso 3
                case 3: {
                    System.out.println("Ingrese los datos del cliente: ");
                    System.out.println("Nombre: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoCliente = scanner.nextLine();
                    System.out.println("Teléfono: ");
                    String telefonoCliente = scanner.nextLine();
                    System.out.println("Edad: ");
                    int edadCliente = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    System.out.println("ID: ");
                    String idCliente = scanner.nextLine();
                    System.out.println("Presupuesto: ");
                    float presupuestoCliente = scanner.nextFloat();
                    scanner.nextLine(); // Consumir el salto de línea

                    Cliente cliente = new ClienteBuilder()
                            .setNombreCliente(nombreCliente)
                            .setApellidoCliente(apellidoCliente)
                            .setTelefonoCliente(telefonoCliente)
                            .setEdadCliente(edadCliente)
                            .setIdCliente(idCliente)
                            .setPresupuestoCliente(presupuestoCliente)
                            .builderCliente();

                    System.out.println("Ingrese el ID de la propiedad a arrendar: ");
                    String idPropiedadArrendar = scanner.nextLine();
                    boolean propiedadEncontrada = false;

                    for (Propiedad propiedad : listapropiedades) {
                        if (propiedad.getIdPropiedad().equals(idPropiedadArrendar)) {
                            propiedadEncontrada = true;
                            boolean arrendada = agente.ArrendarPropiedad(propiedad, cliente);

                            if (arrendada) {
                                System.out.println("Propiedad arrendada exitosamente, generando contrato...");
                                System.out.print("Ingrese la fecha de inicio del contrato (YYYY-MM-DD): ");
                                DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate Inicio = LocalDate.parse(scanner.nextLine(), formatterInicio);

                                System.out.print("Ingrese la fecha de fin del contrato (YYYY-MM-DD): ");
                                DateTimeFormatter formatterFin = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                                LocalDate Fin = LocalDate.parse(scanner.nextLine(), formatterFin);

                                ContratoArrendamientoReal contrato = agente.generContratoArrendamiento(propiedad,
                                        cliente, agente, Inicio, Fin);
                                contrato.obtenerInformacionContrato();
                                listaContrato.add(contrato);
                                System.out.println("Contrato generado exitosamente.");
                            } else {
                                System.out.println("La propiedad ya está arrendada.");
                            }
                            break;
                        }
                    }

                    if (!propiedadEncontrada) {
                        System.out.println("Propiedad con ID " + idPropiedadArrendar + " no encontrada.");
                    }
                    break;
                }

                // caso 4
                case 4: {
                    System.out.println("Ingrese el ID del cliente: ");
                    String idCliente = scanner.nextLine();
                    boolean clienteEncontrado = false;

                    for (ContratoArrendamientoReal contrato : listaContrato) {
                        if (contrato.getCliente().getIdPersona().equals(idCliente)) {
                            clienteEncontrado = true;
                            System.out.println(contrato.obtenerInformacionContrato());
                        }
                    }

                    if (!clienteEncontrado) {
                        System.out.println("Cliente con ID " + idCliente + " no encontrado.");
                    }
                    break;
                }

                // caso 5
                case 5: {
                    System.out.println("Ingrese el ID de la propiedad a liberar: ");
                    String idPropiedadLiberar = scanner.nextLine();
                    boolean propiedadEncontrada = false;
                    for (Propiedad propiedad : listapropiedades) {
                        if (propiedad.getIdPropiedad().equals(idPropiedadLiberar)) {
                            propiedadEncontrada = true;
                            propiedad.setEstaArrendada(false);
                            System.out.println("Propiedad liberada exitosamente.");
                        }

                    }
                    if (!propiedadEncontrada) {
                        System.out.println("Propiedad con ID " + idPropiedadLiberar + " no encontrada.");
                    }
                    break;

                }

                // caso 6
                case 6: {
                    float ingreso = 0;
                    for (Propiedad propiedad : listapropiedades) {
                        ingreso += propiedad.getValorArriendo();

                        contador.registrarIngreso(propiedad.getValorArriendo());
                    }
                    float ingresosTotales = contador.calcularTotalIngresos();

                    // Mostrar finanzas
                    System.out.println("Finanzas de la inmobiliaria:");
                    System.out.println("Ingresos totales: " + ingresosTotales);
                    break;
                }

            }
        } while (opcionPrincipal != 8);

        scanner.close();
    }
}