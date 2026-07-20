package model;

import interfaces.Registrable;

public class GuiaTuristico extends Persona implements Registrable {

    private String especialidad;

    public GuiaTuristico(String nombre, String apellido, Rut rut, Direccion direccion,
                         String telefono, String correo, String nacionalidad,
                         String especialidad) {

        super(nombre, apellido, rut, direccion, telefono, correo, nacionalidad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void registrar() {
        System.out.println("Guía " + getNombre() + " registrado correctamente.");
    }

    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecialidad: " + especialidad;
    }
}
