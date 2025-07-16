package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.InputMismatchException;

import models.Patient;
import models.User;
import models.Appointment;
import service.IAppointmentService;
import service.IBillService;
import service.ILoginService;
import service.IPatientService;

public class ReceptionistDashboard{

  public static void runReceptionistPanel(Scanner sc, IAppointmentService appointmentSerivce, IBillService billService, ILoginService loginService, IPatientService patientService){

    while(true){
      System.out.println("1.Patient Registration\n2.Appointment Scheduling\n3.Consultation Billing\n4.Daily Collection Reports\n5.Exit");
      try{
        System.out.println("Enter choice:");
        int choice = sc.nextInt();

        switch (choice) {
          case 1:
            patientRegistration(sc, appointmentSerivce, loginService, patientService);   
            break;

          case 2:
            appointmentScheduling(sc, appointmentSerivce);
            break;

          case 3:
            System.out.println("\nThe Consultation Fee is 500\n");
            break;

          case 4:
            generateCollectionReports(billService);
            break;

          case 5:
            return;

          default:
            System.out.println("Enter a valid input");
            break;
        }
      }
    catch(InputMismatchException e){
      System.out.println("Incorrect input. Please try again");
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }
    }

  }

  public static void patientRegistration(Scanner sc, IAppointmentService appointmentService, ILoginService loginService, IPatientService patientService){

    try{
      sc.nextLine();
      System.out.println("Enter the Patient Name:");
      String patientName = sc.nextLine();
      System.out.println("Enter the Contact No:");
      String contactNo = sc.nextLine();
      System.out.println("Enter address:");
      String address = sc.nextLine();
      System.out.println("Enter DOB(dd/mm/yy):");
      String DoB = sc.nextLine();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate dob = LocalDate.parse(DoB, formatter);
      System.out.println("Enter Gender:");
      String gender = sc.nextLine();
      Patient p = new Patient(patientName, contactNo, address, dob, gender);
      User user = new User(patientName, DoB, 5, p);
      loginService.addLoginCredentials(user);
      appointmentService.registerPatient(p);
      patientService.registerPatient(p);
      System.out.println("Patient is registered successfully");
    }
    catch(InputMismatchException e){
      System.out.println("Incorrect input. Please try again");
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }

  }

  public static void appointmentScheduling(Scanner sc, IAppointmentService appointmentService){

    try{
      sc.nextLine();
      System.out.println("Enter the Patient Username:");
      String patientName = sc.nextLine();
      System.out.println("Enter the Doctor Name:");
      String doctorName = sc.nextLine();
      Appointment a = appointmentService.appointmentScheduling(patientName, doctorName);
      System.out.println("Your Token No:"+a.getTokenNo());
      System.out.println("Your Appointment Time:"+a.getAppointmentTime());
      System.out.println("============================");
    }
    catch(InputMismatchException e){
      System.out.println("Incorrect input. Please try again");
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }

  }

  public static void generateCollectionReports(IBillService billService){

    try{
      billService.generateDailyCollectionReport();
    }
    catch(InputMismatchException e){
      System.out.println("Incorrect input. Please try again");
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }

  }

}
