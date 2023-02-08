package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{
    //Atributos
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Doctor(String name, String email){
        super(name, email);
        System.out.println("El nombre del doctor asidnado es " + name);
        this.speciality = speciality;
    }

       ArrayList<AvailabAppointment> availabAppointments = new ArrayList<>();
    public void addvailabAppointment(String date, String time) throws ParseException {
        availabAppointments.add(new Doctor.AvailabAppointment(date, time));

    }

    public ArrayList<AvailabAppointment> getAvailabAppointments(){
        return availabAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availabAppointments.toString();
    }

        @Override
        public void showDataUser() {
            System.out.println("Empleado del Hostipal: Cruz Roja");
            System.out.println("Departamento: Odontologia");
        }

        public static class AvailabAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");

        public AvailabAppointment(String date, String time) throws ParseException {
            this.date = format.parse(date);
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public String getDate(String DATE) {
            return format.format(date);
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
            return "Available Appointments \nDate: " +date+ "\nTime: " + time;
        }
    }
}
