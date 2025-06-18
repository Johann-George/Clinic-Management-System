package app;

import java.util.Scanner;

import service.IAppointmentService;

public class PatientDashboard{
  
  public static void runPatientPanel(Scanner sc, IAppointmentService appointmentService){
  
    System.out.println("1.Book Appointment\n2.View prescription\n3.View Lab Reports\n4.Billing History");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        bookAppointment(sc, appointmentService);
        break;

      case 2:
        viewPrescription();
        break;

      case 3:
        viewLabReports();
        break;

      case 4:
        billingHistory();
        break;
    
      default:
        break;
    }

  }

  public static void bookAppointment(Scanner sc, IAppointmentService appointmentService){

    System.out.println("Enter the Patient ID:");
    String patientId = sc.nextLine();
    System.out.println("Enter the Doctor ID:");
    String doctorId = sc.nextLine();
    appointmentService.appointmentScheduling();

  }

  public static void viewPrescription(){

    

  }

}
