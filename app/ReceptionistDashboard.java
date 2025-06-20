package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Patient;
import models.Appointment;
import service.IAppointmentService;
import service.IBillService;

public class ReceptionistDashboard{

  public static void runReceptionistPanel(Scanner sc, IAppointmentService appointmentSerivce, IBillService billService){

    System.out.println("1.Patient Registration\n2.Appointment Scheduling\n3.Consultation Billing\n4.Daily Collection Reports\n5.Exit");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        patientRegistration(sc, appointmentSerivce);   
        break;

      case 2:
        appointmentScheduling(sc, appointmentSerivce);
        break;

      case 3:
        consultationBilling(sc, billService);
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

  public static void patientRegistration(Scanner sc, IAppointmentService appointmentService){

    sc.nextLine();
    System.out.println("Enter the Patient ID:");
    String patientId = sc.nextLine();
    System.out.println("Enter the Patient Name:");
    String patientName = sc.nextLine();
    System.out.println("Enter the Contact No:");
    String contactNo = sc.nextLine();
    System.out.println("Enter address:");
    String address = sc.nextLine();
    System.out.println("Enter DOB(dd/mm/yy):");
    String DoB = sc.nextLine();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate dob = LocalDate.parse(DoB, formatter);
    System.out.println("Enter Gender:");
    String gender = sc.nextLine();
    Patient p = new Patient(patientName, contactNo, address, dob, gender);
    appointmentService.registerPatient(p);
    System.out.println("Patient is registered successfully");

  }

  public static void appointmentScheduling(Scanner sc, IAppointmentService appointmentService){

    System.out.println("Enter the Patient Username:");
    String patientName = sc.nextLine();
    System.out.println("Enter the Doctor ID:");
    String doctorId = sc.nextLine();
    appointmentService.appointmentScheduling(patientName, doctorId);

  }

  public static void consultationBilling(Scanner sc, IBillService billService){

    System.out.println("Enter the Patient Username:");
    String patientName = sc.nextLine();
    System.out.println("Enter the Doctor ID:");
    String doctorId = sc.nextLine();
    billService.consultationBilling(patientName, doctorId);

  }

  public static void generateCollectionReports(IBillService billService){

    billService.generateDailyCollectionReport();

  }

}
