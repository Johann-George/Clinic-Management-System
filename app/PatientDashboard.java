package app;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import service.IAppointmentService;
import service.IPatientService;
import service.IBillService;
import models.Consultation;

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
        //viewLabReports();
        System.out.println("View Lab reports coming soon");
        break;

      case 4:
        billingHistory(sc, billService);
        break;
    
      default:
        break;
    }

  }

  public static void bookAppointment(Scanner sc, IAppointmentService appointmentService){

    System.out.println("Enter the Patient Username:");
    String patientName= sc.nextLine();
    System.out.println("Enter the Doctor ID:");
    String doctorId = sc.nextLine();
    appointmentService.appointmentScheduling(patientName, doctorId);

  }

  public static void viewPrescription(Scanner sc, IPatientService patientService){

    List<String> medicine = new ArrayList<>();
    List<String> labTest = new ArrayList<>();
    System.out.println("Enter the patient Name:");
    String patientName = sc.nextLine();
    System.out.println("Enter the consultation Date:");
    String dt = sc.nextLine();
    LocalDate date = LocalDate.parse(dt);
    System.out.println("The prescriptions in sorted by Date:");
    for(Consultation c : patientService.viewPrescription(patientName)){
      if(c.getConsultationDate().equals(date)){
        medicine.addAll(c.getAllMedicines());
        labTest.addAll(c.getAllLabTests());
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

    System.out.println("Enter the patient Name:");
    String patientName = sc.nextLine();
    billService.generatePatientBillingHistory(patientName);

  }

}
