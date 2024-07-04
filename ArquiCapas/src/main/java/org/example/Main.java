package org.example;

import org.example.controller.UserController;
import org.example.model.User;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {



    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Usuario");
            System.out.println("2. Obtener Usuario");
            System.out.println("3. Eliminar Usuario");
            System.out.println("4. Salir");
            System.out.print("Ingresa tu opción: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Ingresa el ID del usuario: ");
                    String userId = scanner.nextLine();
                    System.out.print("Ingresa el nombre: ");
                    String name = scanner.nextLine();
                    while (name.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío. Ingresa nuevamente: ");
                        name = scanner.nextLine();
                    }
                    System.out.print("Ingresa el correo: ");
                    String email = scanner.nextLine();
                    while (email.isEmpty() || !userController.isValidEmail(email)) {
                        System.out.println("El correo no puede estar vacío y debe ser válido contener el @.com. Ingresa nuevamente: ");
                        email = scanner.nextLine();
                    }
                    User newUser = new User(userId, name, email);
                    userController.saveUser(newUser);
                    System.out.println("¡Usuario agregado exitosamente!");
                    break;

                case "2":
                    System.out.print("Ingresa el ID del usuario: ");
                    String searchId = scanner.nextLine();
                    User foundUser = userController.getUserById(searchId);
                    if (foundUser != null) {
                        System.out.println("ID del Usuario: " + foundUser.getId() +
                                ", Nombre: " + foundUser.getName() +
                                ", Correo: " + foundUser.getEmail());
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case "3":
                    System.out.print("Ingresa el ID del usuario: ");
                    String deleteId = scanner.nextLine();
                    if (userController.deleteUser(deleteId)) {
                        System.out.println("¡Usuario eliminado exitosamente!");
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            }
        }
    }

}


