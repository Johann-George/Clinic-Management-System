package app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import models.Consultation;
import service.IConsultationService;

public class DoctorDashboard{

  public static void runDoctorPanel(Scanner sc, IConsultationService consultationService){

    while(true){
      System.out.println("1.Conduct Consultation\n2.View Patient History\n3.Exit");
      try{
        System.out.println("Enter choice:");
        int choice = sc.nextInt();
        switch (choice) {
          case 1:
            Consultation c = conductConsultation(sc,consultationService);
            prescribeLabTest(c,sc,consultationService);
            prescribeMedicine(c,sc,consultationService);
            break;

          case 2:
            sc.nextLine(); // Consume the newline character left by nextInt()
            System.out.println("=====Patient History=====");
            System.out.println("Enter the patient Username:");
            String patientName = sc.nextLine();
            for(Consultation c1: consultationService.getPatientHistory(patientName)){
              System.out.println("Consultation ID:"+c1.getConsultationId()+"\nDiagnosis Details:"+c1.getDiagnosis()+"\nConsultation Date:"+c1.getConsultationDate()); 
            }
            System.out.println("======================");
            break;

          case 3:
            return;

          default:
            System.out.println("Enter a valid choice");
            break;
        }
      }
      catch(InputMismatchException e){
        System.out.println("Incorrect input. Please enter a value between 1 and 3");
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

  // All consultations details are entered here
  public static Consultation conductConsultation(Scanner sc, IConsultationService consultationService){

    Consultation consultation = null;
    try{
      sc.nextLine();
      System.out.println("Enter Token No:");
      String tokenNo = sc.nextLine();
      System.out.println("======Enter patient details=======");
      System.out.println("Enter the Patient Username:");
      String patientName = sc.nextLine();
      System.out.println("Enter the diagnosis details:");
      String diagnosisDetails = sc.nextLine();
      consultation = consultationService.conductConsultation(tokenNo, patientName, diagnosisDetails);
    }
    catch(NullPointerException e){
      System.out.println("Some data values are missing. Please try again");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }
    return consultation;
  }

  // Lab tests prescribed by the doctor are entered and displayed here
  public static void prescribeLabTest(Consultation c, Scanner sc, IConsultationService consultationService){

    try{
      System.out.println("Enter Token No:");
      String tokenNo = sc.nextLine();
      System.out.println("Enter the number of Lab Tests:");
      int labTestNo = sc.nextInt();
      List<String> labTest = new ArrayList<>();
      sc.nextLine(); // Consume the newline character left by nextInt()
      // Loop to enter the lab tests
      for(int i=0;i<labTestNo;i++){
        System.out.println("Enter the prescribed Lab Test:");
        labTest.add(sc.nextLine());
      }
      consultationService.addLabTest(tokenNo, labTest);
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

  // Medicines are prescribed by the doctor are entered and displayed here
  public static void prescribeMedicine(Consultation c, Scanner sc, IConsultationService consultationService){

    try{
      System.out.println("Enter Token No:");
      String tokenNo = sc.nextLine();
      System.out.println("Enter the number of prescribed Medicines:");
      int medicineNo = sc.nextInt();
      sc.nextLine();
      List<String> medicine = new ArrayList<>();
      for(int i=0;i<medicineNo;i++){
        System.out.println("Enter the prescribed Medicine:");
        medicine.add(sc.nextLine());
      }
      consultationService.addMedicine(tokenNo, medicine);
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
