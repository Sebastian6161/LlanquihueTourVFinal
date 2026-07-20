package model;

import interfaces.Registrable;

public class Cliente extends Persona implements Registrable {

    private int puntosFidelidad;

    public Cliente(String nombre, String apellido, Rut rut, Direccion direccion,
                   String telefono, String correo, String nacionalidad,
                   int puntosFidelidad) {

        super(nombre, apellido, rut, direccion, telefono, correo, nacionalidad);
        this.puntosFidelidad = puntosFidelidad;
    }

    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }

    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }

    @Override
    public void registrar() {
        System.out.println("Cliente " + getNombre() + " registrado correctamente.");
    }

    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPuntos de fidelidad: " + puntosFidelidad;
    }
}