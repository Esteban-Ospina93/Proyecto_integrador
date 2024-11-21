package ui;

import model.Appointment;
import model.Veterinary;

import java.util.Scanner;

import static ui.UIMainMenu.veterinaryLogged;

public class UIVeterinaryMenu {

    public static void showVeterinaryMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Bienvenido " + veterinaryLogged.getName());
            System.out.println("Seleccione la opción deseada: ");
            System.out.println("1: Ver mis citas disponibles");
            System.out.println("2: Ver mis citas agendadas");
            System.out.println("3: Agregar cita disponible");
            System.out.println("0: Salir de sesión");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAvailableAppointments(veterinaryLogged);
                    break;

                case 2:
                    showVeterinaryScheduledAppointments(veterinaryLogged);
                    break;

                case 3:
                    addAvailableAppointment(veterinaryLogged);
                    break;

                case 0:
                    System.out.println("Saliendo de la sesión...");
                    UIMainMenu.showMenu();
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (response != 0);
    }

    // Función que muestra las citas disponibles relacionadas a un doctor (el que reciba como parámetro)
    private static void showVeterinaryScheduledAppointments(Veterinary veterinary) {
        if (veterinary.getScheduledAppointments().size() > 0) {
            System.out.println("Citas agendadas para el veterinario " + veterinary.getName() + ":");
            for (Appointment a : veterinary.getScheduledAppointments()) {
                System.out.println(a.toString());
            }
        } else {
            System.out.println("No hay citas agendadas para este veterinario.");
        }
    }

    // Función para mostrar las citas disponibles que puede agendar un veterinario
    private static void showAvailableAppointments(Veterinary veterinaryLogged) {
        if (veterinaryLogged.getAvailableAppointments().size() > 0) {
            System.out.println("Citas disponibles:");
            for (Appointment appointment : veterinaryLogged.getAvailableAppointments()) {
                System.out.println(appointment.toString());
            }
        } else {
            System.out.println("No hay citas disponibles para el veterinario: " + veterinaryLogged.getName());
        }
    }

    // Función para agregar una cita disponible y que los veterinarios puedan escogerla para agendarla
    private static void addAvailableAppointment(Veterinary veterinaryLogged) {
        Scanner sc = new Scanner(System.in);

        // Solicitar fecha y hora
        System.out.println("Ingrese la fecha de la cita (formato: dd/mm/yyyy): ");
        String date = sc.nextLine();

        System.out.println("Ingrese la hora de la cita (formato: hh:mm): ");
        String time = sc.nextLine();

        veterinaryLogged.addAvailableAppointment(date, time);
    }
}
