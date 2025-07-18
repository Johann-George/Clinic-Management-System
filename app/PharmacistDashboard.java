package app;

import java.util.Scanner;
import java.util.Map;
import java.util.InputMismatchException;

import models.Consultation;
import service.IConsultationService;
import service.IBillService;
import service.InventoryStocks;

public class PharmacistDashboard{

  public static void runPharmacistPanel(Scanner sc, IConsultationService consultationService, IBillService billService){

    while(true){
      System.out.println("1.Manage medicine prescription\n2.Generate cash collection\n3.Generate stock report\n4.Exit");
      try{
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

  public static void sellMedicine(Scanner sc, IConsultationService consultationService){

      // Logic to sell medicine
    try{
      sc.nextLine();
      System.out.println("Enter Patient Token No:"); 
      String tokenNo = sc.nextLine();
      Consultation c = consultationService.getConsultationByTokenNo(tokenNo);
      if(c == null){
        System.out.println("Consultation is null");
      }
      //Stock of each medicine is displayed
      System.out.println("The medicines are:");
      for(String medicine: c.getAllMedicines()){
        System.out.println("Medicine:"+medicine+"\tStock:"+InventoryStocks.getInventoryStocks(medicine));
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
 
  public static void consultationBilling(Scanner sc, IBillService billService){

    try{
      System.out.println("Enter the Patient Username:");
      String patientName = sc.nextLine();
      System.out.println("Enter the Patient Token No:");
      String doctorName = sc.nextLine();
      billService.consultationBilling(patientName, doctorName);
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
