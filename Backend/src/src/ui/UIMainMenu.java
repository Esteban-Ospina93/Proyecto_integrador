package ui;

import model.Customer;
import model.Veterinary;
import model.Animal;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMainMenu {

    // ArrayLists que simulan las bases de datos de usuarios
    private static ArrayList<Veterinary> veterinaries = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();

    // Variables de usuario logueado para ejecutar los procesos usandolo como referencia
    public static Customer customerLogged = null;
    public static Veterinary veterinaryLogged = null;

    static {
        // Datos predefinidos de veterinarios y clientes
        veterinaries.add(new Veterinary(1, "Jhorman Salazar", 28, "3001234567", "123456789", "jhorman@example.com", "Cardiología"));
        veterinaries.add(new Veterinary(2, "Melissa Gómez", 32, "3109876543", "987654321", "melissa@example.com", "Dermatología"));
        veterinaries.add(new Veterinary(4, "Esteban López", 36, "3002233445", "789123456", "esteban@example.com", "Neurología"));
        veterinaries.add(new Veterinary(5, "Alejandro Martínez", 30, "3114455667", "654321987", "alejandro@example.com", "Oftalmología"));

        customers.add(new Customer(1, "Jhorman Salazar", 28, "3001234567", "123456789", "jhorman@example.com", new Animal(1, "Firulais", 3, "Perro")));
        customers.add(new Customer(2, "Melissa Gómez", 32, "3109876543", "987654321", "melissa@example.com", new Animal(2, "Michi", 2, "Gato")));
        customers.add(new Customer(3, "Jose Rodríguez", 40, "3201122334", "456789123", "jose@example.com", new Animal(3, "Rex", 5, "Perro")));
        customers.add(new Customer(4, "Esteban López", 36, "3002233445", "789123456", "esteban@example.com", new Animal(4, "Coco", 4, "Loro")));
        customers.add(new Customer(5, "Alejandro Martínez", 30, "3114455667", "654321987", "alejandro@example.com", new Animal(5, "Bunny", 1, "Conejo")));
    }

    // Menu principal, el que se muestra al ejecutar el programa
    public static void showMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Bienvenido a la aplicación de veterinaria");
            System.out.println("Seleccione la opción deseada: ");
            System.out.println("1: Iniciar sesión como cliente");
            System.out.println("2: Iniciar sesión como veterinario");
            System.out.println("3: Registrar su usuario Veterinario/Cliente");
            System.out.println("0: Salir");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    authUser(2); // Cliente
                    response = 0;
                    break;
                case 2:
                    authUser(1);  // Veterinario
                    response = 0;
                    break;
                case 3:
                    registerUser();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    break;
            }
        } while (response != 0);
    }

    // Función para autenticar al usuario según su tipo y si el correo es correcto
    private static void authUser(int userType) {
        boolean emailCorrect = false;
        Scanner sc = new Scanner(System.in);


        do {
            System.out.println("Login de usuario");
            System.out.println("Escribe tu correo electrónico siguiendo las reglas: [a@a.com]");
            String email = sc.nextLine();

            if (userType == 1) {
                for (Veterinary vet : veterinaries) {
                    if (vet.getEmail().equals(email)) {
                        System.out.println("Login de veterinario exitoso!");
                        emailCorrect = true;
                        veterinaryLogged = vet;
                        UIVeterinaryMenu.showVeterinaryMenu();
                    }
                }
            }

            if (userType == 2) {
                for (Customer cus : customers) {
                    if (cus.getEmail().equals(email)) {
                        System.out.println("Login de cliente exitoso!");
                        emailCorrect = true;
                        customerLogged = cus;
                        UICustomerMenu.showCustomerMenu();
                    }
                }
            }

            if (!emailCorrect) {
                System.out.println("Email no encontrado, por favor verifica o regístrate.");
            }
        } while (!emailCorrect);
    }

    // Función para registrar un nuevo usuario, sea Veterinario o Cliente
    private static void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecciona el tipo de usuario a registrar:");
        System.out.println("1: Veterinario");
        System.out.println("2: Cliente");
        int userType = Integer.valueOf(sc.nextLine());

        System.out.println("Ingresa el nombre:");
        String name = sc.nextLine();
        System.out.println("Ingresa la edad:");
        int age = Integer.valueOf(sc.nextLine());
        System.out.println("Ingresa el número de teléfono:");
        String phone = sc.nextLine();
        System.out.println("Ingresa su cédula de ciudadanía:");
        String cc = sc.nextLine();
        System.out.println("Ingresa el correo electrónico:");
        String email = sc.nextLine();

        if (userType == 1) {  // Veterinario
            System.out.println("Ingresa la especialidad:");
            String specialty = sc.nextLine();
            Veterinary newVet = new Veterinary(veterinaries.size() + 1, name, age, phone, cc, email, specialty);
            veterinaries.add(newVet);
            System.out.println("¡Veterinario registrado exitosamente!");
        } else if (userType == 2) {  // Cliente
            System.out.println("Ingresa el nombre del animal o mascota:");
            String animalName = sc.nextLine();
            System.out.println("Ingresa la edad del animal o mascota:");
            int animalAge = Integer.valueOf(sc.nextLine());
            System.out.println("Ingresa el tipo de animal o mascota:");
            String animalType = sc.nextLine();
            Animal newAnimal = new Animal(customers.size() + 1, animalName, animalAge, animalType);
            Customer newCustomer = new Customer(customers.size() + 1, name, age, phone, cc, email, newAnimal);
            customers.add(newCustomer);
            System.out.println("¡Cliente registrado exitosamente!");
        } else {
            System.out.println("Tipo de usuario inválido.");
        }
    }
}
