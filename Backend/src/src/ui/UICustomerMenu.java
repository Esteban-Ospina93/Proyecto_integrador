package ui;

import model.Appointment;
import model.Customer;

import java.util.Scanner;

import static ui.UIMainMenu.customerLogged;
import static ui.UIMainMenu.veterinaryLogged;

public class UICustomerMenu {

    public static void showCustomerMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Bienvenido " + customerLogged.getName());
            System.out.println("Seleccione la opción deseada: ");
            System.out.println("1: Ver citas disponibles");
            System.out.println("2: Agendar cita");
            System.out.println("3: Ver mis citas agendadas");
            System.out.println("0: Salir de sesión");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    // Ver citas disponibles del veterinario
                    showAvailableAppointments();
                    break;

                case 2:
                    // Agendar una cita
                    scheduleAppointment();
                    break;

                case 3:
                    // Ver mis citas agendadas
                    showCustomerAppointments(customerLogged);
                    break;

                case 0:
                    // Volver al menú principal
                    System.out.println("Saliendo de la sesión...");
                    UIMainMenu.showMenu();
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }
        } while (response != 0);
    }

    //Mostrar citas disponibles de un doctor, para ser agendado por un paciente
    private static void showAvailableAppointments() {
        // Mostrar las citas disponibles del veterinario
        System.out.println("\nCitas disponibles:");
        for (Appointment a : veterinaryLogged.getAvailableAppointments()) {
            System.out.println(a.toString());
        }
    }

    //Agendar cita
    private static void scheduleAppointment() {
        // Ver las citas disponibles
        System.out.println();
        showAvailableAppointments();

        // Elegir una cita para agendar
        System.out.println("Ingrese el ID de la cita que desea agendar:");
        Scanner sc = new Scanner(System.in);
        int appointmentId = Integer.parseInt(sc.nextLine());

        // Buscar la cita seleccionada
        Appointment appointmentToSchedule = null;
        for (Appointment a : veterinaryLogged.getAvailableAppointments()) {
            if (a.getAppointmentId() == appointmentId) {
                appointmentToSchedule = a;
                break;
            }
        }

        // Si la cita fue encontrada, la agendamos
        if (appointmentToSchedule != null) {
            appointmentToSchedule.setCustomer(customerLogged);
            System.out.println("Ingresa la razón de consulta al veterinario: ");
            appointmentToSchedule.setReason(sc.nextLine());
            veterinaryLogged.scheduleAppointment(appointmentToSchedule);
            customerLogged.addToAppointments(appointmentToSchedule);
        } else {
            System.out.println("Cita no encontrada.");
        }
    }

    //Mostrar citas agendadas en el paciente logueado
    private static void showCustomerAppointments(Customer customerLogged) {
        if (customerLogged.getAppointments().size() > 0){
            for (Appointment a: customerLogged.getAppointments()) {
                System.out.println("\n"+a.toString(customerLogged));
            }
        }
        else {
            System.out.println("Aún no has agendado citas "+ customerLogged.getName()+ "verifica que haya un doctor con citas disponibles y si es así agenda la tuya!");
        }
    }
}
