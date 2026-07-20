package utils;

import data.GestorTurismo;
import exceptions.RutInvalidoException;
import model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorArchivo {

    public static void cargarPersonas(String ruta, GestorTurismo gestor) {

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String tipo = datos[0];
                String nombre = datos[1];
                String apellido = datos[2];
                String rut = datos[3];
                String calle = datos[4];
                int numero = Integer.parseInt(datos[5]);
                String ciudad = datos[6];
                String region = datos[7];
                String pais = datos[8];
                String telefono = datos[9];
                String correo = datos[10];
                String nacionalidad = datos[11];

                Direccion direccion = new Direccion(
                        calle,
                        numero,
                        ciudad,
                        region,
                        pais
                );

                Rut nuevoRut = new Rut(rut);

                switch (tipo.toUpperCase()) {

                    case "CLIENTE":

                        int puntos = Integer.parseInt(datos[12]);

                        Cliente cliente = new Cliente(
                                nombre,
                                apellido,
                                nuevoRut,
                                direccion,
                                telefono,
                                correo,
                                nacionalidad,
                                puntos
                        );

                        gestor.agregarPersona(cliente);
                        break;

                    case "GUIA":

                        String especialidad = datos[12];

                        GuiaTuristico guia = new GuiaTuristico(
                                nombre,
                                apellido,
                                nuevoRut,
                                direccion,
                                telefono,
                                correo,
                                nacionalidad,
                                especialidad
                        );

                        gestor.agregarPersona(guia);
                        break;

                    case "PROVEEDOR":

                        String empresa = datos[12];

                        Proveedor proveedor = new Proveedor(
                                nombre,
                                apellido,
                                nuevoRut,
                                direccion,
                                telefono,
                                correo,
                                nacionalidad,
                                empresa
                        );

                        gestor.agregarPersona(proveedor);
                        break;
                }

            }

            System.out.println("Personas cargadas correctamente.");

        } catch (IOException | RutInvalidoException e) {
            System.out.println("Error al cargar personas: " + e.getMessage());
        }

    }

    public static void cargarPaquetes(String ruta, GestorTurismo gestor) {

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                PaqueteTuristico paquete = new PaqueteTuristico(
                        datos[0],
                        datos[1],
                        Double.parseDouble(datos[2]),
                        Integer.parseInt(datos[3])
                );

                gestor.agregarPaquete(paquete);

            }

            System.out.println("Paquetes cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al cargar paquetes: " + e.getMessage());
        }

    }
}