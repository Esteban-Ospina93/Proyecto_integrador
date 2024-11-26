package model;

import java.util.ArrayList;

public class Customer extends Person {
    private Animal animal;
    private ArrayList<Appointment> appointments = new ArrayList<>();  // Citas agendadas del cliente

    public Customer() {}

    public Customer(Integer id, String name, Integer age, String telephone, String CC, String email, Animal animal) {
        super(id, name, age, telephone, CC, email);
        this.animal = animal;
    }

    public void requestAppointment(Appointment appointment, String reason) {
        appointment.setCustomer(this);
        appointment.setReason(reason);
        appointments.add(appointment);
    }


    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addToAppointments(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public String toString() {
        return "Customer: " + getName() + ", with Id: " + getId() + ", Age: " + getAge() + ", With pet: " + animal.toString();
    }
}
