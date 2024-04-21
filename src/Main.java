import gestor.empresarial.empresa.Empresa;
import gestor.empresarial.contrato.Cargos;
import gestor.empresarial.datos.DatosEmpresariales;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa("Itera S.A. de C.V.", "RFC123456789", "221353424", "Victor Zacatzontle");

        boolean continuar = true;
        do {
            System.out.println("1. Registrar solicitante");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Asignar contrato");
            System.out.println("4. Mostrar información de empleado");
            System.out.println("5. Mostrar información de la empresa");
            System.out.println("6. Mostrar información de contratos");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarSolicitante(empresa);
                    break;
                case 2:
                    registrarEmpleado(empresa);
                    break;
                case 3:
                    asignarContrato(empresa);
                    break;
                case 4:
                    mostrarInfoEmpleado(empresa);
                    break;
                case 5:
                    mostrarInfoEmpresa(empresa);
                    break;
                case 6:
                    mostrarInfoContratos(empresa);
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (continuar);
    }

    private static void registrarSolicitante(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del solicitante:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese los apellidos del solicitante:");
        String apellidos = scanner.nextLine();
        System.out.println("Ingrese el correo del solicitante:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese el número de WhatsApp del solicitante:");
        String whatsapp = scanner.nextLine();

        int idGenerado = empresa.datosRH.addDatosPersonales(nombre, apellidos, correo, whatsapp);
        if (idGenerado > 0) {
            System.out.println("Solicitante registrado con ID: " + idGenerado);
        } else {
            System.out.println("Error al registrar el solicitante.");
        }
    }
    private static void registrarEmpleado(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID del solicitante:");
        int idSolicitante = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        DatosEmpresariales datosSolicitante = empresa.datosRH.getDatosPersonales(idSolicitante);
        if (datosSolicitante != null) {
            // Se muestra la información del solicitante
            System.out.println("Información del solicitante:");
            System.out.println("Nombre: " + datosSolicitante.getNombre());
            System.out.println("Apellidos: " + datosSolicitante.getApellidos());
            System.out.println("Correo: " + datosSolicitante.getCorreo());
            System.out.println("WhatsApp: " + datosSolicitante.getWhatsApp());

            // Solicitar los datos empresariales del empleado
            System.out.println("Ingrese la adscripción del empleado:");
            String adscripcion = scanner.nextLine();
            System.out.println("Ingrese el teléfono exterior del empleado:");
            String telefonoExterior = scanner.nextLine();
            System.out.println("Ingrese el puesto del empleado:");
            String puesto = scanner.nextLine();

            // Agregar los datos empresariales al empleado
            empresa.datosRH.addDatosEmpresariales(idSolicitante, adscripcion, telefonoExterior, puesto);
            System.out.println("Empleado registrado con éxito.");
        } else {
            System.out.println("No se encontró ningún solicitante con el ID proporcionado.");
        }
    }
        private static void asignarContrato(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del empleado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el número de contrato:");
        int noContrato = scanner.nextInt();
        System.out.println("Ingrese el año del contrato:");
        int annio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese el horario del contrato:");
        String horario = scanner.nextLine();

        System.out.println("Ingrese el tipo de cargo:");
        System.out.println("1. DE_CONFIANZA");
        System.out.println("2. SINDICALIZADO");
        System.out.println("3. TEMPORAL");
        int opcion = scanner.nextInt();
        Cargos tipoCargo;

        switch (opcion) {
            case 1:
                tipoCargo = Cargos.DE_CONFIANZA;
                break;
            case 2:
                tipoCargo = Cargos.SINDICALIZADO;
                break;
            case 3:
                tipoCargo = Cargos.TEMPORAL;
                break;
            default:
                System.out.println("Opción no válida, se asignará cargo por defecto.");
                tipoCargo = Cargos.TEMPORAL; // Cargo por defecto
                break;
        }

        // Asigna el contrato al empleado en la empresa
        empresa.datosRH.addContrato(id, noContrato, annio, horario, tipoCargo);
        System.out.println("Contrato asignado con éxito.");
    }

    private static void mostrarInfoEmpleado(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del empleado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Muestra la información del empleado
        empresa.datosRH.showDatosEmpleado(id);
    }

    private static void mostrarInfoEmpresa(Empresa empresa) {
        // Muestra la información de la empresa
        empresa.datosRH.showEmpresa();
    }

    private static void mostrarInfoContratos(Empresa empresa) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del empleado:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        // Muestra la información de los contratos del empleado
        empresa.datosRH.showContratosEmpleado(id);
    }
}