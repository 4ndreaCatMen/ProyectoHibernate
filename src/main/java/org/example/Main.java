package org.example;

import DAO.InterfazAnimalesImpl;
import DAO.InterfazUsuariosImpl;
import entities.Animales;
import entities.Usuarios;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InterfazAnimalesImpl animalesDAO = new InterfazAnimalesImpl();
        InterfazUsuariosImpl usuariosDAO = new InterfazUsuariosImpl();

        int opcion;
        do {
            System.out.println("\n--- Bienvendidx al Refugio Andrea, ¿Qué acción desea realizar? ---");
            System.out.println("1. Registrar nuevx usuarix");
            System.out.println("2. Buscar al usuarix por ID");
            System.out.println("3. Ver lista de todxs los usuarixs");
            System.out.println("4. Agregar un nuevo animal");
            System.out.println("5. Buscar al animal por ID");
            System.out.println("6. Ver lista de todos los animales");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    agregarUsuario(scanner, usuariosDAO);
                    break;
                case 2:
                    buscarUsuarioPorId(scanner, usuariosDAO);
                    break;
                case 3:
                    listarUsuarios(usuariosDAO);
                    break;
                case 4:
                    agregarAnimal(scanner, animalesDAO, usuariosDAO);
                    break;
                case 5:
                    buscarAnimalPorId(scanner, animalesDAO);
                    break;
                case 6:
                    listarAnimales(animalesDAO);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static void agregarUsuario(Scanner scanner, InterfazUsuariosImpl usuariosDAO) {
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese edad del usuario: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese ciudad del usuario: ");
        String ciudad = scanner.nextLine();

        Usuarios usuario = new Usuarios();
        usuario.setNombre(nombre);
        usuario.setEdad(edad);
        usuario.setCiudad(ciudad);

        usuariosDAO.create(usuario);
        System.out.println("Usuario agregado con éxito.");
    }

    private static void buscarUsuarioPorId(Scanner scanner, InterfazUsuariosImpl usuariosDAO) {
        System.out.print("Ingrese el ID del usuario: ");
        int id = scanner.nextInt();
        Usuarios usuario = usuariosDAO.findById(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getNombre() + ", " + usuario.getEdad() + " años, Ciudad: " + usuario.getCiudad());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private static void listarUsuarios(InterfazUsuariosImpl usuariosDAO) {
        List<Usuarios> usuarios = usuariosDAO.findAll();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuarios usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + " | Nombre: " + usuario.getNombre() + " | Ciudad: " + usuario.getCiudad());
            }
        }
    }

    private static void agregarAnimal(Scanner scanner, InterfazAnimalesImpl animalesDAO, InterfazUsuariosImpl usuariosDAO) {
        System.out.print("Ingrese el nombre del animal: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la especie del animal: ");
        String especie = scanner.nextLine();
        System.out.print("Ingrese la edad del animal: ");
        int edad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el estado del animal: ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario (familia de acogida): ");
        int usuarioId = scanner.nextInt();

        Usuarios usuario = usuariosDAO.findById(usuarioId);
        if (usuario != null) {
            Animales animal = new Animales();
            animal.setNombre(nombre);
            animal.setEspecie(especie);
            animal.setEdad(edad);
            animal.setDescripcion(descripcion);
            animal.setEstado(estado);
            animal.setUsuario(usuario);

            animalesDAO.create(animal);
            System.out.println("Animal agregado con éxito.");
        } else {
            System.out.println("Usuario no encontrado, no se puede asignar el animal.");
        }
    }

    private static void buscarAnimalPorId(Scanner scanner, InterfazAnimalesImpl animalesDAO) {
        System.out.print("Ingrese el ID del animal: ");
        int id = scanner.nextInt();
        Animales animal = animalesDAO.findById(id);
        if (animal != null) {
            System.out.println("Animal encontrado: " + animal.getNombre() + " - " + animal.getEspecie());
        } else {
            System.out.println("Animal no encontrado.");
        }
    }

    private static void listarAnimales(InterfazAnimalesImpl animalesDAO) {
        List<Animales> animales = animalesDAO.findAll();
        if (animales.isEmpty()) {
            System.out.println("No hay animales registrados.");
        } else {
            for (Animales animal : animales) {
                System.out.println("ID: " + animal.getId() + " | Nombre: " + animal.getNombre() + " | Especie: " + animal.getEspecie() + " | Estado: " + animal.getEstado());
            }
        }
    }
}
