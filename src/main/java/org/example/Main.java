package org.example;

import DAO.InterfazAnimalesImpl;
import DAO.InterfazUsuariosImpl;
import entities.Animales;
import entities.Usuarios;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InterfazAnimalesImpl animalesDAO = new InterfazAnimalesImpl();
        InterfazUsuariosImpl usuariosDAO = new InterfazUsuariosImpl();

        while (true) {
            System.out.println("\n--- Refugio Andrea, ¿Qué acción quiere realizar? ---");
            System.out.println("1. Registrar un animal");
            System.out.println("2. Buscar animales por especie");
            System.out.println("3. Actualizar estado de un animal");
            System.out.println("4. Asociar un animal a una familia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del animal: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Especie del animal: ");
                    String especie = scanner.nextLine();
                    System.out.print("Edad del animal: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Estado del animal (Recién abandonado / Tiempo en el refugio / Próximamente en acogida): ");
                    String estado = scanner.nextLine();

                    Animales nuevoAnimal = new Animales();
                    nuevoAnimal.setNombre(nombre);
                    nuevoAnimal.setEspecie(especie);
                    nuevoAnimal.setEdad(edad);
                    nuevoAnimal.setDescripcion(descripcion);
                    nuevoAnimal.setEstado(estado);

                    animalesDAO.create(nuevoAnimal);
                    System.out.println("Animal registrado con estado '" + estado + "'.");
                    break;

                case 2:
                    System.out.print("Introduce la especie a buscar: ");
                    String especieBuscar = scanner.nextLine();
                    animalesDAO.findByEspecie(especieBuscar)
                            .forEach(a -> System.out.println("ID: " + a.getId() + ", Nombre: " + a.getNombre() + ", Estado: " + a.getEstado()));
                    break;

                case 3:
                    System.out.print("ID del animal a actualizar: ");
                    int animalId = scanner.nextInt();
                    scanner.nextLine();
                    Animales animal = animalesDAO.findById(animalId);
                    if (animal != null) {
                        System.out.println("Estados disponibles: Recién abandonado, Tiempo en el refugio, Próximamente en acogida");
                        System.out.print("Nuevo estado: ");
                        String nuevoEstado = scanner.nextLine();
                        animal.setEstado(nuevoEstado);
                        animalesDAO.update(animal);
                        System.out.println("Estado del animal actualizado a: " + nuevoEstado);
                    } else {
                        System.out.println("No se encontró el animal con el ID proporcionado.");
                    }
                    break;

                case 4:
                    System.out.print("ID del animal: ");
                    int idAnimal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre adoptante: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edadUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ciudad: ");
                    String ciudadUsuario = scanner.nextLine();

                    Animales animalAAdoptar = animalesDAO.findById(idAnimal);
                    if (animalAAdoptar != null) {
                        Usuarios usuario = new Usuarios();
                        usuario.setNombre(nombreUsuario);
                        usuario.setEdad(edadUsuario);
                        usuario.setCiudad(ciudadUsuario);
                        usuariosDAO.create(usuario);
                        animalAAdoptar.setUsuario(usuario);
                        animalAAdoptar.setEstado("Próximamente en acogida");
                        animalesDAO.update(animalAAdoptar);
                        System.out.println("El animal ha sido asociado a la familia y su estado actualizado a 'Próximamente en acogida'.");
                    } else {
                        System.out.println("Animal no encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Error");
            }
        }
    }
}
