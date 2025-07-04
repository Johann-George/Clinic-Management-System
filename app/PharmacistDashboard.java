package app;

import java.util.Scanner;

import service.IConsultationService;
import service.IBillService;

public class PharmacistDashboard{

  public static void runPharmacistPanel(Scanner sc, IConsultationService consultationService, IBillService billService){

    while(true){
      System.out.println("1.Manage medicine prescription\n2.View Inventory\n3.Generate cash collection\n4.Generate stock report\n5.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();

      switch(choice){

        case 1:
          sellMedicine(sc, consultationService);
          consultationBilling(sc, billService);
          break;

        case 2:
          //Inventory coming soon
          // viewInventory();
          break;

        case 3:
          //cash collection report coming soon
          // generateCashCollection();
          break;

        case 4:
        // stock report coming soon
          // generateStockReports();
          break;

        case 5:
          return;

        default:
          System.out.println("Enter a valid value!");

      }
    }

  }

  public static void sellMedicine(Scanner sc, IConsultationService consultationService){

    // Logic to sell medicine
    System.out.println("Enter Patient Token No:"); 
    String tokenNo = sc.nextLine();
    Consultation c = consultationService.getConsultationByTokenNo(tokenNo);
    System.out.println("The medicines are:");
    for(String medicine: c.getAllMedicines()){
      System.out.println(medicine);
    }

  }
 

  public static void consultationBilling(Scanner sc, IBillService billService){

    sc.nextLine();
    System.out.println("Enter the Patient Username:");
    String patientName = sc.nextLine();
    System.out.println("Enter the Doctor Username:");
    String doctorName = sc.nextLine();
    billService.consultationBilling(patientName, doctorName);

  }

}
