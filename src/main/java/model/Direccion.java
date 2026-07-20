package model;

public class Direccion {

    private String calle;
    private int numero;
    private String ciudad;
    private String region;
    private String pais;

    public Direccion(String calle, int numero, String ciudad, String region, String pais) {

        setCalle(calle);
        setNumero(numero);
        setCiudad(ciudad);
        setRegion(region);
        setPais(pais);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {

        if (calle != null && !calle.trim().isEmpty()) {
            this.calle = calle;
        } else {
            throw new IllegalArgumentException("La calle no puede estar vacía.");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {

        if (numero > 0) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException("El número debe ser mayor que cero.");
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {

        if (ciudad != null && !ciudad.trim().isEmpty()) {
            this.ciudad = ciudad;
        } else {
            throw new IllegalArgumentException("La ciudad no puede estar vacía.");
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {

        if (region != null && !region.trim().isEmpty()) {
            this.region = region;
        } else {
            throw new IllegalArgumentException("La región no puede estar vacía.");
        }
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {

        if (pais != null && !pais.trim().isEmpty()) {
            this.pais = pais;
        } else {
            throw new IllegalArgumentException("El país no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return calle + " " + numero +
                ", " + ciudad +
                ", " + region +
                ", " + pais;
    }
}
