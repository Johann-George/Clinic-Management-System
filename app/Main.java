package app;

import java.util.Scanner;

public class Main{

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    
    while(true){

      System.out.println("1.Admin\n2.Doctor\n3.Receptionist\n4.Pharmacist\n5.Lab Technician\n6.Patient");
      System.out.println("Enter the role you want:");
      int role = sc.nextInt();

      switch (role) {
        case 1:
          AdminDashboard.runAdminPanel(sc);
          break;

        case 2:
          System.out.println("Doctor dashboard coming soon..");
          break;

        case 3:
          System.out.println("Receptionist dashboard coming soon..");
          break;

        case 4:
          System.out.println("Pharmacist dashboard coming soon..");
          break; 

        case 5:
          System.out.println("Lab Technician dashboard coming soon..");
          break;

        case 6:
          System.out.println("Patient dashboard coming soon..");
          break;

        default:
          System.out.println("Enter a valid input");
          break;
      }

    }

  }


}
