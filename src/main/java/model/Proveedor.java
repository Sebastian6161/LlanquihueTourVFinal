package model;

import interfaces.Registrable;

public class Proveedor extends Persona implements Registrable {

    private String empresa;

    public Proveedor(String nombre, String apellido, Rut rut, Direccion direccion,
                     String telefono, String correo, String nacionalidad,
                     String empresa) {

        super(nombre, apellido, rut, direccion, telefono, correo, nacionalidad);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void registrar() {
        System.out.println("Proveedor " + getNombre() + " registrado correctamente.");
    }

    @Override
    public void mostrarDatos() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEmpresa: " + empresa;
    }
}
