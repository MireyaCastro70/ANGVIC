import gestor.empresarial.contrato.Cargos;
import gestor.empresarial.empresa.Empresa;
import gestor.empresarial.empleados.Empleados;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = inicializarEmpresa();
        Empleados empleados = new Empleados();

        int opcion;
        do {
            System.out.println("\n*** EMT-SYSTEM ***");
            System.out.println("1. Registrar aspirante");
            System.out.println("2. Registrar empleado");
            System.out.println("3. Asignar contrato a un empleado");
            System.out.println("4. Mostrar información de un empleado");
            System.out.println("5. Mostrar información de un aspirante");
            System.out.println("6. Mostrar información de la empresa");
            System.out.println("7. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarAspirante(empleados, scanner);
                    break;
                case 2:
                    registrarEmpleado(empleados, scanner);
                    break;
                case 3:
                    asignarContrato(empleados, scanner);
                    break;
                case 4:
                    mostrarInformacionEmpleado(empleados, scanner);
                    break;
                case 5:
                    mostrarInformacionAspirante(empleados, scanner);
                    break;
                case 6:
                    mostrarInformacionEmpresa(empresa);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 7);
    }

    private static Empresa inicializarEmpresa() {
        // Inicializar la empresa Itera México con los datos proporcionados
        return new Empresa("Itera S.A. de C.V.", "RFC123456789", "221353424", "Victor Zacatzontle");
    }

    private static void registrarAspirante(Empleados empleados, Scanner scanner) {
        System.out.println("\n*** Registro de aspirante ***");
        System.out.print("Ingrese el ID del aspirante: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el nombre del aspirante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del aspirante: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el correo del aspirante: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el WhatsApp del aspirante: ");
        String whatsapp = scanner.nextLine();

        // Agregar aspirante usando el método de Empleados
        empleados.addDatosPersonales(nombre, apellido, correo, whatsapp);
        System.out.println("Aspirante registrado exitosamente.");
    }

    private static void mostrarInformacionAspirante(Empleados empleados, Scanner scanner) {
        System.out.println("\n*** Mostrar información de un aspirante ***");
        System.out.print("Ingrese el ID del aspirante: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        String infoAspirante = empleados.getInfoDatosPersonales(id);
        if (!infoAspirante.isEmpty()) {
            System.out.println(infoAspirante);
        } else {
            System.out.println("Aspirante no encontrado.");
        }
    }

    private static void registrarEmpleado(Empleados empleados, Scanner scanner) {
        System.out.println("\n*** Registro de empleado ***");
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese la adscripción del empleado: ");
        String adscripcion = scanner.nextLine();
        System.out.print("Ingrese el teléfono de extensión del empleado: ");
        String telefonoExtension = scanner.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = scanner.nextLine();

        empleados.addEmpleado(id, adscripcion, telefonoExtension, puesto);
        System.out.println("Empleado registrado exitosamente.");
    }

    private static void asignarContrato(Empleados empleados, Scanner scanner) {
        System.out.println("\n*** Asignación de contrato ***");
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese el año del contrato: ");
        int anioContrato = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.println("Seleccione el tipo de cargo:");
        System.out.println("1. De confianza");
        System.out.println("2. Sindicalizado");
        System.out.println("3. Contrato temporal");
        System.out.print("Ingrese su opción: ");
        int opcionCargo = scanner.nextInt();
        Cargos cargo = null;
        switch (opcionCargo) {
            case 1:
                cargo = Cargos.DE_CONFIANZA;
                break;
            case 2:
                cargo = Cargos.SINDICALIZADO;
                break;
            case 3:
                cargo = Cargos.TEMPORAL;
                break;
            default:
                System.out.println("Opción no válida. Se asignará un cargo temporal por defecto.");
                cargo = Cargos.TEMPORAL;
        }

        // Agregar contrato usando el método de Empleados
        empleados.addContrato(id, anioContrato, cargo);
        System.out.println("Contrato asignado exitosamente.");
    }

    private static void mostrarInformacionEmpleado(Empleados empleados, Scanner scanner) {
        System.out.println("\n*** Mostrar información de un empleado ***");
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        String infoEmpleado = empleados.getInfoEmpleado(id);
        if (!infoEmpleado.isEmpty()) {
            System.out.println(infoEmpleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void mostrarInformacionEmpresa(Empresa empresa) {
        System.out.println("\n*** Información de la empresa ***");
        System.out.println(empresa.getInfo());
    }
}