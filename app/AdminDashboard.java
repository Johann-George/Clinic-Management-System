package app;

import java.util.Scanner;
import models.Staff;
import models.Doctor;
import models.Receptionist;
import models.Pharmacist;
import models.LabTechnician;
import service.AdminServiceImpl;
import service.IAdminService;

public class AdminDashboard{

  public static void runAdminPanel(Scanner sc){

    IAdminService adminService = new AdminServiceImpl();
    System.out.println("1.Add Staff\n2.Delete Staff\n3.Exit");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();
    switch (choice) {
      case 1:
        addStaff(sc,adminService);
        break;

      case 2:
        deleteStaff(sc,adminService);
        break;
    
      case 3:
        return;

      default:
        System.out.println("Enter a valid input");
        break;
    }

  }

  public static void addStaff(Scanner sc,IAdminService adminService){

    System.out.println("1.Doctor\n2.Receptionist\n3.Pharmacist\n4.Lab Technician");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();
    Staff staff = null;
    System.out.println("Enter ID:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter name:");
    String name = sc.nextLine();

    switch (choice) {
      case 1:
        System.out.println("Enter specialization:");
        String spec = sc.nextLine();
        staff = new Doctor(id,name,spec);
        break;

      case 2:
        staff = new Receptionist(id,name);
        break;

      case 3:
        staff = new Pharmacist(id,name);
        break;

      case 4:
        staff = new LabTechnician(id,name);
        break;
    
      default:
        System.out.println("Enter a valid input");
        break;
    }
    adminService.registerStaff(staff);
    System.out.println("Staff added successfully!");

  }

  public static void deleteStaff(Scanner sc,IAdminService adminService){

    System.out.println("Enter the ID:");
    int id = sc.nextInt();
    adminService.deleteStaff(id);
    System.out.println("Staff is removed successfully!");

  } 

}
