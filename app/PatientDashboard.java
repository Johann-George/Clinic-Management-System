package app;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

import service.IAppointmentService;
import service.ILabTestService;
import service.IPatientService;
import service.IBillService;
import models.Consultation;
import models.Patient;
import models.LabTest;

public class PatientDashboard{
  
  public static void runPatientPanel(Scanner sc, IAppointmentService appointmentService, IPatientService patientService, IBillService billService, ILabTestService labTestService){
  
    while(true){
      System.out.println("1.Book Appointment\n2.View prescription\n3.View Lab Reports\n4.Billing History\n5.Exit");
      try{
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
            viewLabReports(sc, patientService, labTestService);
            break;

          case 4:
            billingHistory(sc, billService);
            break;

          case 5:
            return;
        
          default:
            break;
        }
      }
      catch(InputMismatchException e){
        System.out.println("Invalid input. Please enter a number.");
      }
      catch(NullPointerException e){
        System.out.println("Some data values are missing. Please try again");
      }
      catch(Exception e){
        System.out.println("An unexpected error occured "+e.getMessage());
        e.printStackTrace();
      }
    }

  }

  public static void bookAppointment(Scanner sc, IAppointmentService appointmentService){

    try{
      System.out.println("Enter the Patient Username:");
      String patientName= sc.nextLine();
      System.out.println("Enter the Doctor Username:");
      String doctorName = sc.nextLine();
      appointmentService.appointmentScheduling(patientName, doctorName);
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }
  }

  public static void viewPrescription(Scanner sc, IPatientService patientService){

    try{
      List<String> medicine = new ArrayList<>();
      List<String> labTest = new ArrayList<>();
      sc.nextLine();
      System.out.println("Enter the patient Name:");
      String patientName = sc.nextLine();
      System.out.println("Enter the consultation Date:");
      String dt = sc.nextLine();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate date = null;
      try{
      date = LocalDate.parse(dt, formatter);
      }
      catch(DateTimeParseException e){
        System.out.println("Incorrect date format. Please enter the date in dd/MM/YYYY format.");
      }
      for(Consultation c : patientService.viewPrescription(patientName)){
        if(c.getConsultationDate().equals(date)){
          medicine.addAll(c.getAllMedicines());
          labTest.addAll(c.getAllLabTests());
        }
      }
      System.out.println("\nMedicines:");
      for(String m : medicine){
        System.out.println(m);
      }
      System.out.println("\nLab Tests:");
      for(String lt: labTest){
        System.out.println(lt);
      }
      System.out.println("===================");
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

  public static void viewLabReports(Scanner sc, IPatientService patientService, ILabTestService labTestService){

    try{
      sc.nextLine();
      System.out.println("Enter the patient Name:");
      String patientName = sc.nextLine();
      Patient p = patientService.getPatientByName(patientName);
      List<LabTest> ltList = new ArrayList<>();
      ltList.addAll(labTestService.viewLabTestReports(p.getPatientId()));
      for(LabTest lt: ltList){
        System.out.println("Lab Test Name:"+lt.getName()+" Lab Test Result:"+lt.getResult());
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

  public static void billingHistory(Scanner sc, IBillService billService){

    try{
      sc.nextLine();
      System.out.println("Enter the patient Name:");
      String patientName = sc.nextLine();
      billService.generatePatientBillingHistory(patientName);
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
