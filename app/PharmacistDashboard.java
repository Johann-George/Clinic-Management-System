package app;

import java.util.Scanner;
import java.util.Map;

import models.Consultation;
import service.IConsultationService;
import service.IBillService;
import service.InventoryStocks;

public class PharmacistDashboard{

  public static void runPharmacistPanel(Scanner sc, IConsultationService consultationService, IBillService billService){

    while(true){
      System.out.println("1.Manage medicine prescription\n2.Generate cash collection\n3.Generate stock report\n4.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();

      switch(choice){

        case 1:
          sellMedicine(sc, consultationService);
          consultationBilling(sc, billService);
          break;

        case 2:
          billService.generateDailyCollectionReport();
          break;

        case 3:
          //generateStockReports();
          for(Map.Entry<String, Integer> e: InventoryStocks.getAllInventoryStocks().entrySet()){
            System.out.println("Medicine:"+e.getKey()+"\tStock:"+e.getValue());
          }
          break;

        case 4:
          return;

        default:
          System.out.println("Enter a valid value!");

      }
    }

  }

  public static void sellMedicine(Scanner sc, IConsultationService consultationService){

    // Logic to sell medicine
    sc.nextLine();
    System.out.println("Enter Patient Token No:"); 
    String tokenNo = sc.nextLine();
    Consultation c = consultationService.getConsultationByTokenNo(tokenNo);
    //Stock of each medicine is displayed
    System.out.println("The medicines are:");
    for(String medicine: c.getAllMedicines()){
      System.out.println("Medicine:"+medicine+"\tStock:"+InventoryStocks.getInventoryStocks(medicine));
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

  public static void viewInventory(){

    

  }

}
