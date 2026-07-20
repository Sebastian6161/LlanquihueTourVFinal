package data;

import interfaces.Registrable;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorTurismo {

    private List<Registrable> personas;
    private List<PaqueteTuristico> paquetes;
    private List<Reserva> reservas;

    public GestorTurismo() {
        personas = new ArrayList<>();
        paquetes = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    // ==========================
    // PERSONAS
    // ==========================

    public void agregarPersona(Registrable persona) {
        personas.add(persona);
    }

    public List<Registrable> getPersonas() {
        return personas;
    }

    public void mostrarPersonas() {

        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        for (Registrable persona : personas) {
            persona.mostrarDatos();
            System.out.println("--------------------------------");
        }
    }

    public void mostrarClientes() {

        boolean encontrado = false;

        for (Registrable persona : personas) {

            if (persona instanceof Cliente) {
                persona.mostrarDatos();
                System.out.println("--------------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay clientes registrados.");
        }
    }

    public void mostrarGuias() {

        boolean encontrado = false;

        for (Registrable persona : personas) {

            if (persona instanceof GuiaTuristico) {
                persona.mostrarDatos();
                System.out.println("--------------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay guías registrados.");
        }
    }

    public void mostrarProveedores() {

        boolean encontrado = false;

        for (Registrable persona : personas) {

            if (persona instanceof Proveedor) {
                persona.mostrarDatos();
                System.out.println("--------------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay proveedores registrados.");
        }
    }

    public Cliente buscarCliente(String rut) {

        for (Registrable persona : personas) {

            if (persona instanceof Cliente cliente) {

                if (cliente.getRut().getNumero().equalsIgnoreCase(rut)) {
                    return cliente;
                }
            }
        }

        return null;
    }

    // ==========================
    // PAQUETES
    // ==========================

    public void agregarPaquete(PaqueteTuristico paquete) {
        paquetes.add(paquete);
    }

    public List<PaqueteTuristico> getPaquetes() {
        return paquetes;
    }

    public void mostrarPaquetes() {

        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes registrados.");
            return;
        }

        for (PaqueteTuristico paquete : paquetes) {
            System.out.println(paquete);
            System.out.println("--------------------------------");
        }
    }

    public PaqueteTuristico buscarPaquete(String nombre) {

        for (PaqueteTuristico paquete : paquetes) {

            if (paquete.getNombre().equalsIgnoreCase(nombre)) {
                return paquete;
            }
        }

        return null;
    }

    // ==========================
    // RESERVAS
    // ==========================

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void mostrarReservas() {

        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (Reserva reserva : reservas) {
            System.out.println(reserva);
            System.out.println("--------------------------------");
        }
    }

}