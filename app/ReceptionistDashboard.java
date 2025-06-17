import java.util.Scanner;

import models.Patient;
import models.Appointment;
import service.IAppointmentService;

public class ReceptionistDashboard{

  public static void runReceptionistPanel(Scanner sc, IAppointmentService appointmentSerivce){

    System.out.println("1.Patient Registration\n2.Appointment Scheduling\n3.Consultation Billing\n4.Daily Collection Reports\n5.Exit")
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
        consultationBilling();
        break;

      case 4:
        generateCollectionReports();
        break;

      case 5:
        return;

      default:
        System.out.println("Enter a valid input");
        break;
    }

  }

  public static void patientRegistration(Scanner sc, IAppointmentService appointmentService){

    System.out.println("Enter the Patient ID:");
    String patientId = sc.nextLine();
    System.out.println("Enter the Patient Name:");
    String patientName = sc.nextLine();
    System.out.println("Enter the Contact No:");
    String contactNo = sc.nextLine();
    System.out.println("Enter address:");
    String address = sc.nextLine();
    System.out.println("Enter DOB(dd/mm/yy):");
    String dob = sc.nextLine();
    System.out.println("Enter Gender:");
    String gender = sc.nextLine();
    Patient p = new Patient(patientId, patientName, contactNo, address, dob, gender);
    appointmentService.savePatient(patientId);
    System.out.println("Patient is registered successfully");

  }

  public static void appointmentScheduling(Scanner sc, IAppointmentService appointmentService){

    System.out.println("Enter the Patient ID:");
    String patientId = sc.nextLine();
    System.out.println("Enter the Doctor ID:");
    String doctorId = sc.nextLine();
    appointmentService.appointmentScheduling();

  }

  public static void consultationBilling(){



  }

  public static void generateCollectionReports(){

  }

}
