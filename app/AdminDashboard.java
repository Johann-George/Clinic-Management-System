package app;

import java.util.Scanner;
import models.Role;
import models.Staff;
import models.Doctor;
import models.Receptionist;
import models.Pharmacist;
import models.LabTechnician;
import service.AdminServiceImpl;
import service.IAdminService;
import service.ILoginService;
import service.LoginServiceImpl;

public class AdminDashboard{

  public static void runAdminPanel(Scanner sc){

    IAdminService adminService = new AdminServiceImpl();
    ILoginService loginService = new LoginServiceImpl();
    while(true){
    
      System.out.println("1.Add Staff\n2.Delete Staff\n3.Display All Staff\n4.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          addStaff(sc,adminService,loginService);
          break;

        case 2:
          deleteStaff(sc,adminService);
          break;
      
        case 3:
          for(Staff s : adminService.displayAllStaff()){
            System.out.println("Staff ID:"+s.getId()+"\tStaff Name:"+s.getName()+"\tStaff Role:"+s.getRole());
          }
          break;

        case 4:
          return;

        default:
          System.out.println("Enter a valid input");
          break;
      }

    }
  }

  public static void addStaff(Scanner sc,IAdminService adminService,ILoginService loginService){

    System.out.println("1.Doctor\n2.Receptionist\n3.Pharmacist\n4.Lab Technician");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();
    Staff staff = null;
    Role role = null;
    System.out.println("Enter ID:");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.println("Enter name:");
    String name = sc.nextLine();
    System.out.println("Enter DOB:(format : dd/mm/yyyy)");
    String dob = sc.nextLine();

    switch (choice) {
      case 1:
        System.out.println("Enter specialization:");
        String spec = sc.nextLine();
        role = new Role(1,"Doctor");
        staff = new Doctor(id,name,spec,dob,name,dob,role);
        loginService.addLoginCredentials(staff);
        break;

      case 2:
        role = new Role(2,"Receptionist");
        staff = new Receptionist(id,name,dob,name,dob,role);
        loginService.addLoginCredentials(staff);
        break;

      case 3:
        role = new Role(3,"Pharmacist");
        staff = new Pharmacist(id,name,dob,name,dob,role);
        loginService.addLoginCredentials(staff);
        break;

      case 4:
        role = new Role(4,"Lab Technician");
        staff = new LabTechnician(id,name,dob,name,dob,role);
        loginService.addLoginCredentials(staff);
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
