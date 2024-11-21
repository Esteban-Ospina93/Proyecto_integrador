package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
    private Integer appointmentId;
    private Customer customer;
    private String reason;
    private Date date;
    private String time;
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Appointment() {}

    public Appointment(Integer appointmentId, String date, String time) {
        this.appointmentId = appointmentId;
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace(); // Este try catch es diferente ya que usamos el tipo de dato DATE
        }
        this.time = time;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getReason() {
        return reason;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment ID: "+ appointmentId + ",  Date: " + date + ", Time: " + time + ", Customer: " + customer + ", Reason: " + reason;
    }

    public String toString(Customer customer) {
        return "Appointment ID: "+ appointmentId + ",  Date: " + date + ", Time: " + time + ", Customer: " + customer.getName() + ", Reason: " + reason;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
