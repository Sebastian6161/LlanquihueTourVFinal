package model;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Reserva {

    private int codigo;
    private Cliente cliente;
    private PaqueteTuristico paquete;
    private int cantidadPersonas;
    private LocalDate fechaReserva;
    private String estado;

    public Reserva(int codigo, Cliente cliente,
                   PaqueteTuristico paquete,
                   int cantidadPersonas,
                   LocalDate fechaReserva,
                   String estado) {

        setCodigo(codigo);
        setCliente(cliente);
        setPaquete(paquete);
        setCantidadPersonas(cantidadPersonas);
        setFechaReserva(fechaReserva);
        setEstado(estado);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {

        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException(
                    "El código debe ser mayor que cero."
            );
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {

        if (cliente != null) {
            this.cliente = cliente;
        } else {
            throw new IllegalArgumentException(
                    "La reserva debe tener un cliente."
            );
        }
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {

        if (paquete != null) {
            this.paquete = paquete;
        } else {
            throw new IllegalArgumentException(
                    "La reserva debe tener un paquete turístico."
            );
        }
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {

        if (cantidadPersonas > 0) {
            this.cantidadPersonas = cantidadPersonas;
        } else {
            throw new IllegalArgumentException(
                    "La cantidad de personas debe ser mayor que cero."
            );
        }
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {

        if (fechaReserva != null) {
            this.fechaReserva = fechaReserva;
        } else {
            throw new IllegalArgumentException(
                    "La fecha de la reserva no puede estar vacía."
            );
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        if (estado != null && !estado.trim().isEmpty()) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException(
                    "El estado no puede estar vacío."
            );
        }
    }

    public double calcularTotal() {

        return paquete.getPrecio() * cantidadPersonas;
    }

    @Override
    public String toString() {

        NumberFormat formatoMoneda =
                NumberFormat.getCurrencyInstance(
                        Locale.forLanguageTag("es-CL")
                );

        formatoMoneda.setMaximumFractionDigits(0);

        return "========== RESERVA ==========" +
                "\nCódigo: " + codigo +
                "\nCliente: " + cliente.getNombre()
                + " " + cliente.getApellido() +
                "\nRUT: " + cliente.getRut() +
                "\nPaquete: " + paquete.getNombre() +
                "\nDestino: " + paquete.getDestino() +
                "\nFecha de reserva: " + fechaReserva +
                "\nCantidad de personas: " + cantidadPersonas +
                "\nEstado: " + estado +
                "\nTotal: " + formatoMoneda.format(calcularTotal());
    }
}