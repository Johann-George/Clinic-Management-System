package app;

import java.util.Scanner;
import service.ILoginService;
import service.LoginServiceImpl;
import models.Staff;

//To compile use: javac -d bin Main.java
//To run use: java -cp bin Main
public class Main{

  private static Scanner sc = new Scanner(System.in);
  ILoginService loginService = new LoginServiceImpl();

  public void mainDashboard(){
    
    AdminDashboard.runAdminPanel(sc);
    while(true){
      System.out.println("Enter Username:");
      String username = sc.nextLine();
      System.out.println("Enter Password:");
      String password = sc.nextLine();
      Staff staff = loginService.validateLogin(username,password);
      switch (staff.getRole()) {

        case "Doctor":
          System.out.println("Doctor dashboard coming soon..");
          break;

        case "Receptionist":
          System.out.println("Receptionist dashboard coming soon..");
          break;

        case "Pharmacist":
          System.out.println("Pharmacist dashboard coming soon..");
          break; 

        case "Lab Technician":
          System.out.println("Lab Technician dashboard coming soon..");
          break;

        case "Patient":
          System.out.println("Patient dashboard coming soon..");
          break;

        default:
          System.out.println("Enter a valid input");
          break;
      }

    }

  }
  public static void main(String[] args){
      Main main = new Main();
      main.mainDashboard();
  }


}
