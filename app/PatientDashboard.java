package app;

import java.util.Scanner;

import service.IAppointmentService;
import service.IPatientService;
import service.IBillService;

public class PatientDashboard{
  
  public static void runPatientPanel(Scanner sc, IAppointmentService appointmentService, IPatientService patientService, IBillService billService){
  
    System.out.println("1.Book Appointment\n2.View prescription\n3.View Lab Reports\n4.Billing History");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();

    switch (choice) {
      case 1:
        bookAppointment(sc, appointmentService);
        break;

      case 2:
        viewPrescription(sc, patientService);
        break;

      case 3:
        viewLabReports();
        break;

      case 4:
        billingHistory(sc, billingService);
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
    appointmentService.appointmentScheduling(patientId, doctorId);

  }

  public static void viewPrescription(Scanner sc, IPatientService patientService){

    System.out.println("Enter the patient ID:");
    String patientId = sc.nextLine();
    System.out.println("Enter the consultation Date:");
    String dt = sc.nextLine();
    LocalDate date = LocalDate.parse(dt);
    System.out.println("The prescriptions in sorted by Date:");
    for(Consultation c : patientService.viewPrescription(patientId)){
      if(c.getDate().equals(date)){
        List<String> medicine = new ArrayList<>(c.getMedicine());
        List<String> labTest = new ArrayList<>(c.getLabTest());
      }
    }
    System.out.println("Medicines:");
    for(String m : medicine){
      System.out.println(m);
    }
    System.out.println("Lab Tests:");
    for(String lt: labTest){
      System.out.println(lt);
    }

  }

  public static void billingHistory(Scanner sc, IBillService billService){

    System.out.println("Enter the patient ID:");
    String patientId = sc.nextLine();
    billService.generatePatientBillingHistory(patientId);

  }

}
