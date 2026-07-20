package model;

public class Persona {

    private String nombre;
    private String apellido;
    private Rut rut;
    private Direccion direccion;
    private String telefono;
    private String correo;
    private String nacionalidad;

    public Persona(String nombre, String apellido, Rut rut, Direccion direccion,
                   String telefono, String correo, String nacionalidad) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nRUT: " + rut +
                "\nDirección: " + direccion +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correo +
                "\nNacionalidad: " + nacionalidad;
    }
}
