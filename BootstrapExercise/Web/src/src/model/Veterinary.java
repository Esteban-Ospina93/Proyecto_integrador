package model;

import java.util.ArrayList;

public class Veterinary extends Person {
    private String specialty;
    private ArrayList<Appointment> availableAppointments = new ArrayList<>();
    private ArrayList<Appointment> scheduledAppointments = new ArrayList<>();  // Lista de citas agendadas

    public Veterinary() {}

    public Veterinary(Integer Id, String name, Integer age, String telephone, String CC, String email, String specialty) {
        super(Id, name, age, telephone, CC, email);
        this.specialty = specialty;
    }

    // Método para que el doctor agregue citas disponibles
    public void addAvailableAppointment(String date, String time) {
        try {
            // Crea una nueva cita sin asignar un cliente o razón para que cuando un cliente la agende, ésta se
            // asigne automáticamente a él
            Appointment appointment = new Appointment(availableAppointments.size() + 1, date, time);
            // Agrega la cita a la lista de citas disponibles
            availableAppointments.add(appointment);
            System.out.println("Cita añadida exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar la cita: " + e.getMessage()); // Este try catch es por si el proceso sale mal no se termine sin decirnos por qué
        }
    }

    // Función para que un cliente agende una cita
    public void scheduleAppointment(Appointment appointment) {
        try {
            // Se mueve la cita de "disponible" a "agendada"
            if (availableAppointments.contains(appointment)) {
                availableAppointments.remove(appointment);
                scheduledAppointments.add(appointment);
                System.out.println("Cita agendada exitosamente.");
            } else {
                System.out.println("La cita no está disponible.");
            }
        } catch (Exception e) {
            System.out.println("Error al agendar la cita: " + e.getMessage());
        }
    }

    // Getters y Setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<Appointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public ArrayList<Appointment> getScheduledAppointments() {
        return scheduledAppointments;
    }

    @Override
    public String toString() {
        return "Veterinary: " + getName() + ", with Id: " + getId() + ", Specialty: " + getSpecialty() + ", Age: " + getAge();
    }
}
