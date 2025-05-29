package app;

import java.util.Scanner;

public class Main{

  private static Scanner sc = new Scanner(System.in);
  ILoginService loginService = new LoginServiceImpl();

  public static void main(String[] args) {
    
    while(true){
      System.out.println("Enter Username:");
      String username = sc.nextLine();
      System.out.println("Enter Password:");
      String password = sc.nextLine();
      User user = loginService.validateLogin(username,password);
      switch (user.getRole()) {
        case "Admin":
          AdminDashboard.runAdminPanel(sc);
          break;

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

}
