package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uniquindio.poo.Builder.ContadorBuilder;
import co.edu.uniquindio.poo.Builder.AgenteBuilder;
import co.edu.uniquindio.poo.Builder.ClienteBuilder;
import co.edu.uniquindio.poo.Builder.PropietarioBuilder;
import co.edu.uniquindio.poo.Composite.ConjuntoPropiedad;
import co.edu.uniquindio.poo.Decorator.Componente;
import co.edu.uniquindio.poo.Decorator.ConAireAcondicionado;
import co.edu.uniquindio.poo.Decorator.ConParqueadero;
import co.edu.uniquindio.poo.Factory.IPropiedad;
import co.edu.uniquindio.poo.Factory.PropiedadFactory;

public class InmobiliariaMenu {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {

        ArrayList<Propiedad> listapropiedades = new ArrayList<Propiedad>();
        ArrayList<ContratoArrendamientoReal> listaContrato = new ArrayList<ContratoArrendamientoReal>();
        ArrayList<Float> listaingresos = new ArrayList<>();
        ArrayList<Float> listaegresos = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<Factura> listaFacturas = new ArrayList<>();
        AgenteInmobiliario agente = new AgenteBuilder()

                .setNombreAgente("Juan")
                .setApellidoAgente("Perez")
                .setTelefonoAgente("311245844")
                .setEdadAgente(67)
                .setIdAgente("123")
                .setSueldoMinimo(1000000)
                .setPropiedadesArrendadas(new ArrayList<>())
                .setCliente(listaClientes)
                .builderAgente();

        Contador contador = new ContadorBuilder()
                .setNombreContador("Pedro")
                .setApellidoContador("Gomez")
                .setTelefonoContador("311245844")
                .setEdadContador(67)
                .setIdContador("123")
                .setSueldoContador(10000)
                .setRegistroContable(RegistroContable.getInstanciaRegistroContable(listaingresos, listaegresos))
                .builderContador();

        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal = 0;

        Inmobiliaria inmobiliaria = Inmobiliaria.getInstanciaInmobiliaria("Inmobiliaria programacion", "123",
                "contacto@inmobiliaria.com", listapropiedades, listaContrato);
        ConjuntoPropiedad conjunto = null;
        do {
            System.out.println(ANSI_RED + "\n--- INMOBILIARIA PROGRAMACION ---" + ANSI_RESET);
            System.out.println("1. Agregar Propiedad");
            System.out.println("2. Eliminar Propiedad");
            System.out.println("3. Arrendar Propiedad");
            System.out.println("4. Obtener contrato por cliente");
            System.out.println("5. Generar factura");
            System.out.println("6. Liberar propiedad");
            System.out.println("7. Obtener finanzas de la inmobiliaria");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            // Verificar que la entrada sea un número
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || !input.matches("\\d+")) {
                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 8.");
                continue;
            }

            opcionPrincipal = Integer.parseInt(input);

            // Verificar si el número está en el rango de 1 a 8
            if (opcionPrincipal < 1 || opcionPrincipal > 8) {
                System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 8.");
                continue;
            }

            switch (opcionPrincipal) {

                // caso 1
                case 1: {

                    System.out.println();
                    System.out.println(ANSI_RED + "******  SECCION DE AGREGAR PROPIEDAD  **********" + ANSI_RESET);
                    System.out.println();

                    System.out.println("Tipo de propiedad (casa/apartamento/local): ");
                    String tipoPropiedad;
                    while (true) {
                        tipoPropiedad = scanner.nextLine().trim().toLowerCase();
                        if (tipoPropiedad.equals("casa") || tipoPropiedad.equals("apartamento")
                                || tipoPropiedad.equals("local")) {
                            break;
                        } else {
                            System.out.println(
                                    "Tipo de propiedad no válido. Por favor, ingrese 'casa', 'apartamento' o 'local'.");
                        }
                    }

                    System.out.println("Ingrese la localización de la propiedad: ");
                    String localizacion;
                    while (true) {
                        localizacion = scanner.nextLine().trim();
                        if (!localizacion.isEmpty()) {
                            break;
                        } else {
                            System.out.println(
                                    "La localización no puede estar vacía. Por favor, ingrese una localización válida.");
                        }
                    }

                    System.out.println("Ingrese la descripción de la propiedad: ");
                    String descripcion;
                    while (true) {
                        descripcion = scanner.nextLine().trim();
                        if (!descripcion.isEmpty()) {
                            break;
                        } else {
                            System.out.println(
                                    "La descripción no puede estar vacía. Por favor, ingrese una descripción válida.");
                        }
                    }

                    System.out.println("Ingrese el ID de la propiedad: ");
                    String idPropiedad;
                    while (true) {
                        idPropiedad = scanner.nextLine().trim();
                        boolean idExiste = false;
                        for (Propiedad propiedad : listapropiedades) {
                            if (propiedad.getIdPropiedad().equals(idPropiedad)) {
                                idExiste = true;
                                break;
                            }
                        }
                        if (!idPropiedad.isEmpty() && !idPropiedad.contains(" ") && !idExiste) {
                            break;
                        } else if (idExiste) {
                            System.out.println("El ID de la propiedad ya existe. Por favor, ingrese un ID diferente.");
                        } else {
                            System.out.println(
                                    "El ID de la propiedad no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }

                    System.out.println("Ingrese el valor de arriendo de la propiedad: ");
                    float valorArriendo = 0;
                    while (true) {
                        String inputArriendo = scanner.nextLine().trim();
                        if (!inputArriendo.isEmpty() && inputArriendo.matches("\\d+(\\.\\d+)?")) {
                            valorArriendo = Float.parseFloat(inputArriendo);
                            if (valorArriendo >= 0) {
                                contador.registrarIngreso(valorArriendo, true);
                                break;
                            } else {
                                System.out.println(
                                        "El valor no puede ser negativo. Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }
                    System.out.println("Ingrese el valor del depósito de la propiedad: ");
                    float valorDeposito = 0;
                    while (true) {
                        String inputDeposito = scanner.nextLine().trim();
                        if (!inputDeposito.isEmpty() && inputDeposito.matches("\\d+(\\.\\d+)?")) {
                            valorDeposito = Float.parseFloat(inputDeposito);
                            if (valorDeposito >= 0) {
                                contador.registrarIngreso(valorDeposito, false);
                                break;
                            } else {
                                System.out.println(
                                        "El valor no puede ser negativo. Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }

                    System.out.println("Ingrese la comisión de la propiedad: ");
                    float comision = 0;
                    while (true) {
                        String inputComision = scanner.nextLine().trim();
                        if (!inputComision.isEmpty() && inputComision.matches("\\d+(\\.\\d+)?")) {
                            comision = Float.parseFloat(inputComision);
                            if (comision >= 0) {
                                // contador.registrarEgreso(comision);
                                break;
                            } else {
                                System.out.println(
                                        "El valor no puede ser negativo. Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }
                    System.out.println("Ingrese el nombre del propietario de la propiedad: ");
                    String nombrePropietario = scanner.nextLine().trim();
                    while (nombrePropietario.isEmpty() || !nombrePropietario.matches("[a-zA-Z ]+")) {
                        System.out
                                .println("Nombre no válido. Por favor, ingrese solo letras y puede contener espacios.");
                        nombrePropietario = scanner.nextLine().trim();
                    }

                    System.out.println("Ingrese el apellido del propietario de la propiedad: ");
                    String apellidoPropietario = scanner.nextLine().trim();
                    while (apellidoPropietario.isEmpty() || !apellidoPropietario.matches("[a-zA-Z ]+")) {
                        System.out
                                .println(
                                        "Apellido no válido. Por favor, ingrese solo letras y puede contener espacios.");
                        apellidoPropietario = scanner.nextLine().trim();
                    }

                    System.out.println("Ingrese el teléfono del propietario de la propiedad: ");
                    String telefonoPropietario;
                    while (true) {
                        telefonoPropietario = scanner.nextLine().trim();
                        if (!telefonoPropietario.isEmpty() && telefonoPropietario.matches("\\d+")) {
                            break;
                        } else {
                            System.out.println(
                                    "El teléfono no puede estar vacío y debe contener solo números. Por favor, ingrese un teléfono válido.");
                        }
                    }

                    System.out.println("Ingrese la edad del propietario de la propiedad: ");
                    int edadPropietario = 0;
                    while (true) {
                        String inputEdad = scanner.nextLine().trim();
                        if (!inputEdad.isEmpty() && inputEdad.matches("\\d+")) {
                            edadPropietario = Integer.parseInt(inputEdad);
                            if (edadPropietario >= 0 && edadPropietario <= 130) {
                                break;
                            } else {
                                System.out.println(
                                        "La edad no puede ser negativa ni mayor a 130. Por favor, ingrese un número valido.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                        }
                    }
                    System.out.println("Ingrese el ID del propietario de la propiedad: ");
                    String idPropietario;
                    while (true) {
                        idPropietario = scanner.nextLine().trim();
                        if (!idPropietario.isEmpty() && !idPropietario.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID del propietario no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }

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
                            int numeroPisos = 0;
                            while (true) {
                                System.out.println("Ingrese el número de pisos: ");
                                String inputNumeroPisos = scanner.nextLine().trim();
                                if (!inputNumeroPisos.isEmpty() && inputNumeroPisos.matches("\\d+")
                                        && !inputNumeroPisos.contains(" ")) {
                                    numeroPisos = Integer.parseInt(inputNumeroPisos);
                                    if (numeroPisos >= 0 && numeroPisos <= 4) {
                                        break;
                                    } else {
                                        System.out.println(
                                                "El número de pisos no puede ser negativo ni mayor a 4. Por favor, ingrese un número valido.");
                                    }
                                } else {
                                    System.out.println(
                                            "Entrada no válida. Por favor, ingrese un número entero sin espacios.");
                                }
                            }
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            ((Casa) nuevaPropiedad).setNumeroPisos(numeroPisos);
                            break;
                        }
                        case "apartamento": {

                            float valorAdministracion = 0;
                            while (true) {
                                System.out.println("Ingrese el valor de administración: ");
                                String inputAdministracion = scanner.nextLine().trim();
                                if (!inputAdministracion.isEmpty() && inputAdministracion.matches("\\d+(\\.\\d+)?")
                                        && !inputAdministracion.contains(" ")) {
                                    valorAdministracion = Float.parseFloat(inputAdministracion);
                                    if (valorAdministracion >= 0) {
                                        break;
                                    } else {
                                        System.out.println(
                                                "El valor no puede ser negativo. Por favor, ingrese un número positivo.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número sin espacios.");
                                }
                            }
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            ((Apartamento) nuevaPropiedad).setValorAdministracion(valorAdministracion);
                            break;
                        }
                        case "local": {
                            System.out.println("Ingrese el espacio en bodega:");
                            float espacioBodega = 0;
                            while (true) {
                                String inputEspacioBodega = scanner.nextLine().trim();
                                if (!inputEspacioBodega.isEmpty() && inputEspacioBodega.matches("\\d+(\\.\\d+)?")
                                        && !inputEspacioBodega.contains(" ")) {
                                    espacioBodega = Float.parseFloat(inputEspacioBodega);
                                    if (espacioBodega >= 0) {
                                        break;
                                    } else {
                                        System.out.println(
                                                "El valor no puede ser negativo. Por favor, ingrese un número positivo.");
                                    }
                                } else {
                                    System.out.println("Entrada no válida. Por favor, ingrese un número sin espacios.");
                                }
                            }
                            nuevaPropiedad = factory.crearPropiedad(tipoPropiedad, localizacion, descripcion,
                                    idPropiedad, valorArriendo, valorDeposito, propietario, false, comision);
                            ((Local) nuevaPropiedad).setEspacioBodega(espacioBodega);
                            break;
                        }
                    }

                    if (nuevaPropiedad != null) {
                        propietario.agregarPropiedades(nuevaPropiedad);
                        inmobiliaria.AgregarPropiedad(nuevaPropiedad);
                        listapropiedades.add(nuevaPropiedad);

                        nuevaPropiedad.definirEstrato();

                        Componente propiedadDecorada = nuevaPropiedad;
                        System.out.println("¿Desea agregar caracteristicas adicionales a la propiedad? (si/no): ");
                        String respuestaDecorador;
                        while (true) {
                            respuestaDecorador = scanner.nextLine().toLowerCase();
                            if (respuestaDecorador.equals("si") || respuestaDecorador.equals("no")) {
                                break;
                            } else {
                                System.out.println("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                            }
                        }
                        if (respuestaDecorador.equals("si")) {
                            boolean agregarDecoradores = true;
                            while (agregarDecoradores) {
                                System.out.println("Seleccione una caracteristica adicional: ");
                                System.out.println("1. Con Parqueadero");
                                System.out.println("2. Con Aire Acondicionado");
                                System.out.println("3. Terminar");
                                int opcionDecorador = 0;
                                while (true) {
                                    String inputDecorador = scanner.nextLine().trim();
                                    if (!inputDecorador.isEmpty() && inputDecorador.matches("\\d+")) {
                                        opcionDecorador = Integer.parseInt(inputDecorador);
                                        if (opcionDecorador >= 1 && opcionDecorador <= 3) {
                                            break;
                                        } else {
                                            System.out.println(
                                                    "Opción no válida. Por favor, ingrese un número entre 1 y 3.");
                                        }
                                    } else {
                                        System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                                    }
                                }

                                switch (opcionDecorador) {
                                    case 1:
                                        propiedadDecorada = new ConParqueadero(propiedadDecorada);
                                        System.out.println("Propiedad 'Con Parqueadero' agregado.");
                                        break;
                                    case 2:
                                        propiedadDecorada = new ConAireAcondicionado(propiedadDecorada);
                                        System.out.println("Propiedadr 'Con Aire Acondicionado' agregado.");
                                        break;
                                    case 3:
                                        agregarDecoradores = false;
                                        System.out.println("Finalizando la adición de caracteristicas.");
                                        break;

                                }
                            }
                        }
                        System.out.println("Descripción de la propiedad: " + propiedadDecorada.getDescripcion());

                        System.out.println("¿Desea agregar esta propiedad a un conjunto existente? (si/no): ");
                        String respuesta;
                        while (true) {
                            respuesta = scanner.nextLine().toLowerCase();
                            if (respuesta.equals("si") || respuesta.equals("no")) {
                                break;
                            } else {
                                System.out.println("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                            }
                        }
                        if (respuesta.equals("si")) {
                            System.out.println("Ingrese el nombre del conjunto: ");
                            String nombreConjunto;
                            while (true) {
                                nombreConjunto = scanner.nextLine().trim();
                                if (!nombreConjunto.isEmpty() && nombreConjunto.matches("[a-zA-Z ]+")) {
                                    break;
                                } else {
                                    System.out.println("Nombre no válido. Por favor, ingrese solo letras.");
                                }
                            }

                            for (IPropiedad prop : listapropiedades) {
                                if (prop instanceof ConjuntoPropiedad
                                        && ((ConjuntoPropiedad) prop).getNombreConjunto().equals(nombreConjunto)) {
                                    conjunto = (ConjuntoPropiedad) prop;
                                    break;
                                }
                            }

                            if (conjunto == null) {
                                System.out.println("Conjunto no encontrado. ¿Desea crear un nuevo conjunto? (si/no): ");
                                String crearConjunto;
                                while (true) {
                                    crearConjunto = scanner.nextLine().toLowerCase();
                                    if (crearConjunto.equals("si") || crearConjunto.equals("no")) {
                                        break;
                                    } else {
                                        System.out.println("Respuesta no válida. Por favor, ingrese 'si' o 'no'.");
                                    }
                                }
                                if (crearConjunto.equals("si")) {
                                    conjunto = new ConjuntoPropiedad(nombreConjunto);
                                    listapropiedades.add(nuevaPropiedad);

                                }
                            }

                            if (conjunto != null) {
                                conjunto.agregarPropiedadAlConjunto(nuevaPropiedad);
                                System.out.println("Propiedad agregada al conjunto: " + nombreConjunto);
                            }
                        } else {
                            System.out.println("Propiedad no agregada a ningún conjunto.");
                        }

                        System.out.println();
                        System.out.println(
                                ANSI_RED + "******  FIN DE LA SECCION DE AGREGAR PROPIEDAD ********" + ANSI_RESET);
                        System.out.println();
                    }
                    break;
                }
                // caso 2
                case 2: {
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "****************  SECCION DE ELIMINAR PROPIEDAD  **************************"
                                    + ANSI_RESET);
                    System.out.println();
                    System.out.println("Ingrese el ID de la propiedad a eliminar: ");
                    String idPropiedadEliminar;
                    while (true) {
                        idPropiedadEliminar = scanner.nextLine().trim();
                        if (!idPropiedadEliminar.isEmpty() && !idPropiedadEliminar.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }

                    while (idPropiedadEliminar.isEmpty()) {
                        System.out.println(
                                "El ID no puede estar vacío o contener solo espacios en blanco. Por favor, ingrese un ID válido:");
                        idPropiedadEliminar = scanner.nextLine().trim();
                    }

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
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "******************  FIN DE LA SECCION DE ELIMINAR PROPIEDAD ************************"
                                    + ANSI_RESET);
                    System.out.println();
                    break;
                }

                // caso 3
                case 3: {
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "****************  SECCION DE ARRENDAR PROPIEDAD  **************************"
                                    + ANSI_RESET);
                    System.out.println();
                    System.out.println("Ingrese los datos del cliente: ");
                    System.out.println("Nombre: ");
                    String nombreCliente = scanner.nextLine().trim();
                    while (nombreCliente.isEmpty() || !nombreCliente.matches("[a-zA-Z ]+")) {
                        System.out.println("Nombre no válido. Por favor, ingrese solo letras.");
                        nombreCliente = scanner.nextLine().trim();
                    }
                    System.out.println("Apellido: ");
                    String apellidoCliente = scanner.nextLine().trim();
                    while (apellidoCliente.isEmpty() || !apellidoCliente.matches("[a-zA-Z ]+")) {
                        System.out.println("Apellido no válido. Por favor, ingrese solo letras.");
                        apellidoCliente = scanner.nextLine().trim();
                    }
                    System.out.println("Teléfono: ");
                    String telefonoCliente = scanner.nextLine().trim();
                    while (!telefonoCliente.matches("\\d+")) {
                        System.out.println("Teléfono no válido. Por favor, ingrese solo números sin espacios.");
                        telefonoCliente = scanner.nextLine().trim();
                    }
                    System.out.println("Edad: ");
                    int edadCliente = 0;
                    while (true) {
                        String inputEdad = scanner.nextLine().trim();
                        if (!inputEdad.isEmpty() && inputEdad.matches("\\d+")) {
                            edadCliente = Integer.parseInt(inputEdad);
                            if (edadCliente >= 0 && edadCliente <= 130) {
                                break;
                            } else {
                                System.out.println(
                                        "La edad no puede ser negativa ni mayor a 130. Por favor, ingrese un número válido.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número entero.");
                        }
                    }
                    System.out.println("ID: ");
                    String idCliente;
                    while (true) {
                        idCliente = scanner.nextLine().trim();
                        if (!idCliente.isEmpty() && !idCliente.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }
                    boolean idClienteExiste = false;
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getIdPersona().equals(idCliente)) {
                            idClienteExiste = true;
                            break;
                        }
                    }
                    if (idClienteExiste) {
                        System.out.println("El ID del cliente ya existe. Por favor, ingrese un ID diferente.");
                        continue;
                    }
                    System.out.println("Presupuesto: ");
                    float presupuestoCliente = 0;
                    while (true) {
                        String inputPresupuesto = scanner.nextLine().trim();
                        if (!inputPresupuesto.isEmpty() && inputPresupuesto.matches("\\d+(\\.\\d+)?")) {
                            presupuestoCliente = Float.parseFloat(inputPresupuesto);
                            if (presupuestoCliente >= 0) {
                                break;
                            } else {
                                System.out.println(
                                        "El presupuesto no puede ser negativo. Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }

                    Cliente cliente = new ClienteBuilder()
                            .setNombreCliente(nombreCliente)
                            .setApellidoCliente(apellidoCliente)
                            .setTelefonoCliente(telefonoCliente)
                            .setEdadCliente(edadCliente)
                            .setIdCliente(idCliente)
                            .setPresupuestoCliente(presupuestoCliente)
                            .builderCliente();

                    listaClientes.add(cliente);
                    System.out.println("Ingrese el ID de la propiedad a arrendar: ");
                    String idPropiedadArrendar;
                    while (true) {
                        idPropiedadArrendar = scanner.nextLine().trim();
                        if (!idPropiedadArrendar.isEmpty() && !idPropiedadArrendar.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }
                    boolean propiedadEncontrada = false;

                    for (Propiedad propiedad : listapropiedades) {
                        if (propiedad.getIdPropiedad().equals(idPropiedadArrendar)) {
                            propiedadEncontrada = true;
                            if (presupuestoCliente >= propiedad.getValorArriendo()) {
                                boolean arrendada = agente.ArrendarPropiedad(propiedad, cliente);

                                if (arrendada) {
                                    System.out.println("Propiedad arrendada exitosamente, generando contrato...");
                                    LocalDate Inicio = null;
                                    LocalDate Fin = null;
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                                    while (true) {
                                        try {
                                            System.out.print("Ingrese la fecha de inicio del contrato (YYYY-MM-DD): ");
                                            Inicio = LocalDate.parse(scanner.nextLine(), formatter);
                                            break;
                                        } catch (DateTimeParseException e) {
                                            System.out.println(
                                                    "Fecha no válida. Por favor, ingrese una fecha en el formato YYYY-MM-DD.");
                                        }
                                    }

                                    while (true) {
                                        try {
                                            System.out.print("Ingrese la fecha de fin del contrato (YYYY-MM-DD): ");
                                            Fin = LocalDate.parse(scanner.nextLine(), formatter);
                                            if (Fin.isAfter(Inicio)) {
                                                break;
                                            } else {
                                                System.out.println(
                                                        "La fecha de fin debe ser posterior a la fecha de inicio.");
                                            }
                                        } catch (DateTimeParseException e) {
                                            System.out.println(
                                                    "Fecha no válida. Por favor, ingrese una fecha en el formato YYYY-MM-DD.");
                                        }
                                    }

                                    ContratoArrendamientoReal contrato = agente.generContratoArrendamiento(propiedad,
                                            cliente, agente, Inicio, Fin);
                                    contrato.obtenerInformacionContrato();
                                    listaContrato.add(contrato);
                                    System.out.println("Contrato generado exitosamente.");
                                    propiedad.setEstaArrendada(true);
                                    System.out.println("Notificando al agente inmobiliario.");
                                    agente.notificarEstado(propiedad);
                                    System.out.println("Notificación al propietario: "
                                            + propiedad.getPropietario().getNombrePersona());
                                    propiedad.getPropietario().notificarEstado(propiedad);
                                } else {
                                    System.out.println("La propiedad ya está arrendada.");
                                }
                            } else {
                                System.out.println(
                                        "El presupuesto del cliente no es suficiente para arrendar esta propiedad.");
                            }
                            break;
                        }
                    }

                    if (!propiedadEncontrada) {
                        System.out.println("Propiedad con ID " + idPropiedadArrendar + " no encontrada.");
                    }
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "******************  FIN DE LA SECCION DE ARRENDAR PROPIEDAD ************************"
                                    + ANSI_RESET);
                    System.out.println();
                    break;
                }

                // caso 4
                case 4: {
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "******  SECCION DE OBTENER CONTRATO POR CLIENTE  **********" + ANSI_RESET);
                    System.out.println();

                    System.out.println("Ingrese el ID del cliente: ");
                    String idCliente;
                    while (true) {
                        idCliente = scanner.nextLine().trim();
                        if (!idCliente.isEmpty() && !idCliente.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }
                    boolean clienteEncontrado = false;

                    for (ContratoArrendamientoReal contrato : listaContrato) {
                        if (contrato.getCliente().getIdPersona().equals(idCliente)) {
                            clienteEncontrado = true;

                            // Solicitar ID del agente
                            System.out.println("Ingrese el ID del agente: ");
                            String idAgente;
                            while (true) {
                                idAgente = scanner.nextLine().trim();
                                if (!idAgente.isEmpty() && !idAgente.contains(" ")) {
                                    break;
                                } else {
                                    System.out.println(
                                            "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                                }
                            }

                            System.out.println(contrato.getAgenteInmobiliario().getIdPersona());

                            // Verificar si el ID del agente coincide con el agente asignado
                            if (contrato.getAgenteInmobiliario().getIdPersona().equals(idAgente)) {
                                // Mostrar información del contrato en formato de tabla
                                System.out.println(contrato.obtenerInformacionContrato());
                            } else {
                                System.out.println("El ID del agente no coincide con el agente asignado.");
                            }
                        }
                    }

                    if (!clienteEncontrado) {
                        System.out.println("Cliente con ID " + idCliente + " no encontrado.");
                    }
                    System.out.println();
                    System.out.println(ANSI_RED + "******  FIN DE LA SECCION DE OBTENER CONTRATO POR CLIENTE ********"
                            + ANSI_RESET);
                    System.out.println();
                    break;
                }

                case 5: {
                    System.out.println();
                    System.out.println(ANSI_RED
                            + "****************  SECCION DE GENERAR FACTURA  **************************" + ANSI_RESET);
                    System.out.println();

                    System.out.println("Ingrese el ID del cliente: ");
                    String idClienteFactura;
                    while (true) {
                        idClienteFactura = scanner.nextLine().trim();
                        if (!idClienteFactura.isEmpty() && !idClienteFactura.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }

                    Cliente clienteFactura = null;
                    for (Cliente cliente : listaClientes) {
                        if (cliente.getIdPersona().equals(idClienteFactura)) {
                            clienteFactura = cliente;
                            break;
                        }
                    }

                    if (clienteFactura != null) {
                        ContratoArrendamientoReal contratoCliente = null;
                        for (ContratoArrendamientoReal contrato : listaContrato) {
                            if (contrato.getCliente().getIdPersona().equals(idClienteFactura)) {
                                contratoCliente = contrato;
                                break;
                            }
                        }

                        if (contratoCliente != null) {
                            LocalDate fechaGenerado = LocalDate.now();
                            LocalDate fechaVencimiento = fechaGenerado.plusMonths(1);

                            // Determinar el estado de la transacción
                            EstadoTransaccion estadoTransaccion;
                            if (fechaGenerado.isBefore(fechaVencimiento) || fechaGenerado.isEqual(fechaVencimiento)) {
                                estadoTransaccion = EstadoTransaccion.VIGENTE;
                            } else {
                                estadoTransaccion = EstadoTransaccion.VENCIDO;
                            }

                            Factura factura = new Factura(
                                    System.currentTimeMillis(), // Número de factura generado a partir del tiempo actual
                                    (float) contratoCliente.getValorFinal(),
                                    fechaGenerado,
                                    fechaVencimiento,
                                    estadoTransaccion,
                                    clienteFactura);

                            listaFacturas.add(factura);
                            System.out.println("Factura generada exitosamente:");
                            System.out.println(factura.generarComprobante());
                        } else {
                            System.out.println("No se encontró un contrato para el cliente con ID " + idClienteFactura);
                        }
                    } else {
                        System.out.println("Cliente con ID " + idClienteFactura + " no encontrado.");
                    }

                    System.out.println();
                    System.out.println(ANSI_RED
                            + "******************  FIN DE LA SECCION DE GENERAR FACTURA ************************"
                            + ANSI_RESET);
                    System.out.println();
                    break;
                }

                // caso 6
                case 6: {
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "****************  SECCION DE LIBERAR PROPIEDAD  **************************"
                                    + ANSI_RESET);
                    System.out.println();
                    System.out.println("Ingrese el ID de la propiedad a liberar: ");
                    String idPropiedadLiberar;
                    while (true) {
                        idPropiedadLiberar = scanner.nextLine().trim();
                        if (!idPropiedadLiberar.isEmpty() && !idPropiedadLiberar.contains(" ")) {
                            break;
                        } else {
                            System.out.println(
                                    "El ID no puede estar vacío ni contener espacios. Por favor, ingrese un ID válido.");
                        }
                    }
                    boolean propiedadEncontrada = false;
                    for (Propiedad propiedad : listapropiedades) {
                        if (propiedad.getIdPropiedad().equals(idPropiedadLiberar)) {
                            propiedadEncontrada = true;
                            propiedad.setEstaArrendada(false);
                            System.out.println("Propiedad liberada exitosamente.");
                            System.out.println("Notificando al agente inmobiliario.");
                            agente.notificarEstado(propiedad);
                            System.out.println(
                                    "Notificación al propietario: " + propiedad.getPropietario().getNombrePersona());
                            propiedad.getPropietario().notificarEstado(propiedad);
                        }

                    }
                    if (!propiedadEncontrada) {
                        System.out.println("Propiedad con ID " + idPropiedadLiberar + " no encontrada.");
                    }
                    System.out.println();
                    System.out.println(
                            ANSI_RED + "******************  FIN DE LA SECCION DE LIBERAR PROPIEDAD ************************"
                                    + ANSI_RESET);
                    System.out.println();
                    break;
                }

                // caso 7
                case 7: {

                    System.out.println();
                    System.out.println(
                            ANSI_RED + "******  SECCION DE FINANZAS DE LA INMOBILIARIA  **********" + ANSI_RESET);
                    System.out.println();

                    System.out.println("Ingrese el mes (1-12): ");
                    int mes = 0;
                    while (true) {
                        String Mes = scanner.nextLine().trim();
                        if (!Mes.isEmpty() && Mes.matches("\\d+")) {
                            mes = Integer.parseInt(Mes);
                            if (mes >= 1 && mes <= 12) {
                                break;
                            } else {
                                System.out.println("Mes no válido. Por favor, ingrese un número entre 1 y 12.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }
                    }

                    System.out.println("Ingrese el año: ");
                    int año = 0;
                    while (true) {
                        String Año = scanner.nextLine().trim();
                        if (!Año.isEmpty() && Año.matches("\\d+")) {
                            año = Integer.parseInt(Año);
                            if (año > 0) {
                                break;
                            } else {
                                System.out.println("Año no válido. Por favor, ingrese un número positivo.");
                            }
                        } else {
                            System.out.println("Entrada no válida. Por favor, ingrese un número.");
                        }

                    }
                    // Filtrar contratos por mes y año
                    ArrayList<ContratoArrendamientoReal> contratosFiltrados = new ArrayList<>();
                    for (ContratoArrendamientoReal contrato : listaContrato) {
                        LocalDate fechaInicio = contrato.getFechaInicio();
                        LocalDate fechaFin = contrato.getFechaFin();

                        // Iterar sobre cada mes dentro del rango de fechas del contrato
                        LocalDate fechaActual = fechaInicio.withDayOfMonth(1);
                        while (!fechaActual.isAfter(fechaFin)) {
                            if (fechaActual.getMonthValue() == mes && fechaActual.getYear() == año) {
                                contratosFiltrados.add(contrato);
                                break;
                            }
                            fechaActual = fechaActual.plusMonths(1);
                        }
                    }
                    // Calcular ingresos totales de los contratos filtrados
                    float totalIngresosFiltrados = 0;
                    for (ContratoArrendamientoReal contrato : contratosFiltrados) {
                        totalIngresosFiltrados += contrato.getValorFinal();
                    }

                    // Calcular egresos totales de los contratos filtrados
                    float totalEgresosFiltrados = 0;
                    for (ContratoArrendamientoReal contrato : contratosFiltrados) {
                        totalEgresosFiltrados += contrato.getPropiedad().getComision();
                    }

                    // Calcular finanzas netas de los contratos filtrados
                    float finanzasNetasFiltradas = totalIngresosFiltrados - totalEgresosFiltrados;

                    // Mostrar resultados en formato tabular
                    System.out.println(
                            "\n--- FINANZAS DE LA INMOBILIARIA PARA EL MES " + mes + " DEL AÑO " + año + " ---");
                    System.out.printf("%-20s %-20s %-20s\n", "Ingresos Totales", "Egresos Totales", "Finanzas Netas");
                    System.out.printf("%-20.2f %-20.2f %-20.2f\n", totalIngresosFiltrados, totalEgresosFiltrados,
                            finanzasNetasFiltradas);

                    System.out.println();
                    System.out.println(ANSI_RED + "******  FIN DE LA SECCION DE FINANZAS DE LA INMOBILIARIA ********"
                            + ANSI_RESET);
                    System.out.println();
                    break;
                }

                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcionPrincipal != 8);
        System.out.println(ANSI_RED + "Gracias por usar el sistema de la inmobiliaria" + ANSI_RESET);
        scanner.close();
    }
}