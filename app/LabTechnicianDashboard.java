package app;

import java.util.Scanner;

import service.IConsultationService;
import service.IDGenerator;
import service.ILabTestService;
import models.Consultation;
import models.LabTest;

public class LabTechnicianDashboard{

  public static void runLabTechnicianPanel(Scanner sc, IConsultationService consultationService, ILabTestService labTestService){

    while(true){
      System.out.println("1.View Lab Test Prescriptions\n2.Lab Test Status\n3.Execute Lab Test \n4.Report Generation\n5.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          viewLabTestPrescription(sc, consultationService, labTestService);
          break;

        case 2:
          labTestStatus(sc,labTestService);
          break;

        case 3:
          labTestExecution(sc, labTestService);
          break;

        case 4:
          generateReport(sc, labTestService);
          break;

        case 5:
          return;

        default:
          System.out.println("Enter a valid input");
          break;
      }
    }

  }

  public static void viewLabTestPrescription(Scanner sc, IConsultationService consultationService, ILabTestService labTestService){

    sc.nextLine();
    System.out.println("Enter Patient Token No:");
    String tokenNo = sc.nextLine();
    Consultation c = consultationService.getConsultationByTokenNo(tokenNo);
    System.out.println("The Lab Tests are:");
    for(String labTest: c.getAllLabTests()){
      LabTest lt = new LabTest(IDGenerator.generateID("LT"), labTest, c.getPatientId());
      lt.setStatus("Pending");
      labTestService.saveLabTest(lt);
      System.out.println("Lab Test ID:"+lt.getId()+" Lab Test Name:"+labTest);
      System.out.println("=======================");
    }

  }

  public static void labTestStatus(Scanner sc, ILabTestService labTestService){

    sc.nextLine();
    System.out.println("Enter the Lab Test ID:");
    String labTestId = sc.nextLine();
    LabTest lt = labTestService.getLabTestById(labTestId);
    System.out.println("Status:"+lt.getStatus());

  }

  public static void labTestExecution(Scanner sc, ILabTestService labTestService){

    sc.nextLine();
    System.out.println("Enter the Lab Test ID:");
    String labTestId = sc.nextLine();
    System.out.println("Enter the Test Result:");
    String testResult = sc.nextLine();
    LabTest lt = labTestService.getLabTestById(labTestId);
    lt.setResult(testResult);
    lt.setStatus("In Progress");

  }

  public static void generateReport(Scanner sc, ILabTestService labTestService){

    sc.nextLine();
    System.out.println("Enter the Lab Test ID:");
    String labTestId = sc.nextLine();
    LabTest lt = labTestService.getLabTestById(labTestId);
    System.out.println("Lab Test ID:"+lt.getId()+" Lab Test Name:"+lt.getName()+" Lab Test Result"+lt.getResult());
    lt.setStatus("Completed");

  }

}
