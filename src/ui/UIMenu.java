package ui;

import model.Doctor;
import model.Paciente;

import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class UIMenu {


    public static final String[] MONTHS ={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre",};
    public static Doctor doctorLogged;
    public static Paciente pacienteLogged;

    public static void showMenu() throws ParseException {
        System.out.println("Welcome to my Appointments");
        System.out.println("Selecciona la opcion deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("3. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    authUser(1);
                    response = 0;
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response!=0);
    }

    private static void authUser(int userType) throws ParseException {
        //UserType = 1 Doctor
        //UserType = 2 Paciente

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Jorge Badran", "poro@gmail.com"));
        doctors.add(new Doctor("Jose Jaramillo", "jose@gmail.com"));
        doctors.add(new Doctor("Sara vega", "vega@gmail.com"));

        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Anahi Salgado" , "anahi@gmail.com"));
        pacientes.add(new Paciente("Roberto Rodriguez" , "roberto@gmail.com"));
        pacientes.add(new Paciente("Carlos Sanchez" , "carlos@gmail.com"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [example@gmail.com]");
            Scanner sc = new Scanner((System.in));
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getEmail().equals(email)){
                        emailCorrect = true;
                        //Obtener el usuario loggeado
                        doctorLogged = d;
                        UiDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if (userType ==2){
                for (Paciente p: pacientes){
                    if (p.getEmail().equals(email)){
                        emailCorrect = true;
                        pacienteLogged = p;
                        //showPacienteMenu
                    }
                }
            }
        }while (!emailCorrect);
    }

    static void  showPatientMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Paciente");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i +"." + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response!=0);
    }
}
