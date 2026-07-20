package model;

import java.text.NumberFormat;
import java.util.Locale;

public class PaqueteTuristico {

    private String nombre;
    private String destino;
    private double precio;
    private int duracionDias;

    public PaqueteTuristico(String nombre, String destino,
                            double precio, int duracionDias) {

        setNombre(nombre);
        setDestino(destino);
        setPrecio(precio);
        setDuracionDias(duracionDias);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException(
                    "El nombre del paquete no puede estar vacío."
            );
        }
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {

        if (destino != null && !destino.trim().isEmpty()) {
            this.destino = destino;
        } else {
            throw new IllegalArgumentException(
                    "El destino no puede estar vacío."
            );
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio > 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {

        if (duracionDias > 0) {
            this.duracionDias = duracionDias;
        } else {
            throw new IllegalArgumentException(
                    "La duración debe ser mayor que cero."
            );
        }
    }

    @Override
    public String toString() {

        NumberFormat formatoMoneda =
                NumberFormat.getCurrencyInstance(
                        Locale.forLanguageTag("es-CL")
                );

        formatoMoneda.setMaximumFractionDigits(0);

        return "=== PAQUETE TURÍSTICO ===" +
                "\nNombre: " + nombre +
                "\nDestino: " + destino +
                "\nPrecio: " + formatoMoneda.format(precio) +
                "\nDuración: " + duracionDias + " día(s)";
    }
}