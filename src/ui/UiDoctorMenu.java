package ui;

import model.Doctor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class UiDoctorMenu {

    public static ArrayList<Doctor> doctorAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() throws ParseException {
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Aveilable Appointments");
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAddAvailbleAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;

            }

        }while (response != 0);
    }

    private static void showAddAvailbleAppointmentsMenu() throws ParseException {
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println("::Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i +1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0 Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + " ." + UIMenu.MONTHS[monthSelected-1]);
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your the date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + date + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);

                UIMenu.doctorLogged.addvailabAppointment(date,time);
                checkDotorAvailableAppointments(UIMenu.doctorLogged);

            }else if(response == 0){
                showDoctorMenu();
            }
        }while (response != 0);
    }

    private static void checkDotorAvailableAppointments(Doctor doctor){
        if (doctor.getAvailabAppointments().size() > 0 && !doctorAvailableAppointments.contains(doctor)){
            doctorAvailableAppointments.add(doctor);
        }
    }

}

