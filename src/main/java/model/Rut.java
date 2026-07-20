package model;

import exceptions.RutInvalidoException;

public class Rut {

    private String numero;

    public Rut(String numero) throws RutInvalidoException {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) throws RutInvalidoException {

        if (numero != null && !numero.trim().isEmpty()) {
            this.numero = numero;
        } else {
            throw new RutInvalidoException("El RUT no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return numero;
    }
}