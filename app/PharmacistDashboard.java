package app;

import java.util.Scanner;

import service.IConsultationService;

public class PharmacistDashboard{

  public static void runPharmacistPanel(Scanner sc, IConsultationService consultationService){

    while(true){
      System.out.println("1.Manage medicine prescription\n2.View Inventory\n3.Generate cash collection\n4.Generate stock report\n5.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();

      switch(choice){

        case 1:
          sellMedicine(sc, consultationService);
          billing();
          break;

        case 2:
          viewInventory();
          break;

        case 3:
          generateCashCollection();
          break;

        case 4:
          generateStockReports();
          break;

        case 5:
          return;

        default:
          System.out.println("Enter a valid value!");

      }
    }

  }

  public void sellMedicine(Scanner sc, IConsultationService consultationService){

    // Logic to sell medicine
    System.out.println("Enter Patient Token No:"); 
    String tokenNo = sc.nextLine();
    // consultationService.getConsultationByTokenNo(tokenNo);

  }

}
