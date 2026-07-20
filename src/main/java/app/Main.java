package app;

import data.GestorTurismo;
import model.Cliente;
import model.PaqueteTuristico;
import model.Reserva;
import utils.LectorArchivo;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorTurismo gestor = new GestorTurismo();

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n=========================================");
                    System.out.println("           CARGANDO DATOS");
                    System.out.println("=========================================");

                    LectorArchivo.cargarPersonas(
                            "data/personas.txt",
                            gestor
                    );

                    LectorArchivo.cargarPaquetes(
                            "data/paquetes.txt",
                            gestor
                    );

                    System.out.println("=========================================");

                    break;

                case 2:

                    mostrarTitulo("TODAS LAS PERSONAS");
                    gestor.mostrarPersonas();

                    break;

                case 3:

                    mostrarTitulo("CLIENTES REGISTRADOS");
                    gestor.mostrarClientes();

                    break;

                case 4:

                    mostrarTitulo("GUÍAS TURÍSTICOS");
                    gestor.mostrarGuias();

                    break;

                case 5:

                    mostrarTitulo("PROVEEDORES");
                    gestor.mostrarProveedores();

                    break;

                case 6:

                    mostrarTitulo("PAQUETES TURÍSTICOS");
                    gestor.mostrarPaquetes();

                    break;

                case 7:

                    mostrarTitulo("CREAR RESERVA");

                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutReserva = scanner.nextLine();

                    Cliente clienteReserva =
                            gestor.buscarCliente(rutReserva);

                    if (clienteReserva == null) {
                        mostrarError("No existe un cliente con ese RUT.");
                        break;
                    }

                    System.out.print("Ingrese el nombre del paquete: ");
                    String nombrePaqueteReserva = scanner.nextLine();

                    PaqueteTuristico paqueteReserva =
                            gestor.buscarPaquete(nombrePaqueteReserva);

                    if (paqueteReserva == null) {
                        mostrarError("El paquete turístico no fue encontrado.");
                        break;
                    }

                    System.out.print("Cantidad de personas: ");
                    int cantidadPersonas = scanner.nextInt();
                    scanner.nextLine();

                    if (cantidadPersonas <= 0) {
                        mostrarError(
                                "La cantidad de personas debe ser mayor que cero."
                        );
                        break;
                    }

                    int codigoReserva =
                            gestor.getReservas().size() + 1;

                    Reserva reserva = new Reserva(
                            codigoReserva,
                            clienteReserva,
                            paqueteReserva,
                            cantidadPersonas,
                            LocalDate.now(),
                            "Confirmada"
                    );

                    gestor.agregarReserva(reserva);

                    System.out.println("\n=========================================");
                    System.out.println("        RESERVA REGISTRADA");
                    System.out.println("=========================================");
                    System.out.println("Código: " + codigoReserva);
                    System.out.println(
                            "Cliente: "
                                    + clienteReserva.getNombre()
                                    + " "
                                    + clienteReserva.getApellido()
                    );
                    System.out.println(
                            "Paquete: " + paqueteReserva.getNombre()
                    );
                    System.out.println("Estado: Confirmada");
                    System.out.println("=========================================");

                    break;

                case 8:

                    mostrarTitulo("RESERVAS REGISTRADAS");
                    gestor.mostrarReservas();

                    break;

                case 9:

                    mostrarTitulo("BUSCAR CLIENTE");

                    System.out.print("Ingrese el RUT del cliente: ");
                    String rutBusqueda = scanner.nextLine();

                    Cliente clienteEncontrado =
                            gestor.buscarCliente(rutBusqueda);

                    if (clienteEncontrado == null) {
                        mostrarError("Cliente no encontrado.");
                    } else {
                        mostrarTitulo("CLIENTE ENCONTRADO");
                        System.out.println(clienteEncontrado);
                        System.out.println("=========================================");
                    }

                    break;

                case 10:

                    mostrarTitulo("BUSCAR PAQUETE TURÍSTICO");

                    System.out.print(
                            "Ingrese el nombre del paquete: "
                    );

                    String nombrePaqueteBusqueda =
                            scanner.nextLine();

                    PaqueteTuristico paqueteEncontrado =
                            gestor.buscarPaquete(nombrePaqueteBusqueda);

                    if (paqueteEncontrado == null) {
                        mostrarError(
                                "Paquete turístico no encontrado."
                        );
                    } else {
                        mostrarTitulo("PAQUETE ENCONTRADO");
                        System.out.println(paqueteEncontrado);
                        System.out.println("=========================================");
                    }

                    break;

                case 11:

                    System.out.println("\n=========================================");
                    System.out.println("       LLANQUIHUE TOUR");
                    System.out.println("=========================================");
                    System.out.println("Gracias por utilizar el sistema.");
                    System.out.println("¡Hasta pronto!");
                    System.out.println("=========================================");

                    break;

                default:

                    mostrarError(
                            "Opción inválida. Seleccione entre 1 y 11."
                    );
            }

        } while (opcion != 11);

        scanner.close();
    }

    public static void mostrarMenu() {

        System.out.println("\n=================================================");
        System.out.println("              LLANQUIHUE TOUR");
        System.out.println("          Sistema de Gestión Turística");
        System.out.println("=================================================");
        System.out.println("1. Cargar datos desde archivos");
        System.out.println("2. Mostrar todas las personas");
        System.out.println("3. Mostrar clientes");
        System.out.println("4. Mostrar guías turísticos");
        System.out.println("5. Mostrar proveedores");
        System.out.println("6. Mostrar paquetes turísticos");
        System.out.println("7. Crear reserva");
        System.out.println("8. Mostrar reservas");
        System.out.println("9. Buscar cliente por RUT");
        System.out.println("10. Buscar paquete turístico");
        System.out.println("11. Salir");
        System.out.println("=================================================");
    }

    public static void mostrarTitulo(String titulo) {

        System.out.println("\n=========================================");
        System.out.println("          " + titulo);
        System.out.println("=========================================");
    }

    public static void mostrarError(String mensaje) {

        System.out.println("\n=========================================");
        System.out.println("                ERROR");
        System.out.println("=========================================");
        System.out.println(mensaje);
        System.out.println("=========================================");
    }
}
