package app;

import java.util.Scanner;
import models.Staff;
import models.Doctor;
import models.Receptionist;
import models.Pharmacist;
import models.LabTechnician;
import service.AdminServiceImpl;
import service.IAdminService;
import service.ILoginService;
import service.LoginServceImpl;

public class AdminDashboard{

  public static void runAdminPanel(Scanner sc){

    while(true){
    
      IAdminService adminService = new AdminServiceImpl();
      ILoginService loginService = new LoginServceImpl();
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
            System.out.println("Staff ID:"+s.getId()+"Staff Name:"+s.getName()+"Staff Role:"+s.getRole());
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
    User user = null;
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
        user = new User(name,dob,2,null);
        Doctor dotctor = new Doctor(id,name,spec,user,dob);
        user = new User(name,dob,2,doctor);
        loginService.addLoginCredentials(user);
        break;

      case 2:
        user = new User(name,dob,3,null);
        Receptionist receptionist= new Receptionist(id,name,user,dob);
        user = new User(name,dob,3,receptionist);
        loginService.addLoginCredentials(user);
        break;

      case 3:
        user = new User(name,dob,4,null);
        Pharmacist pharmacist = new Pharmacist(id,name,user,dob);
        user = new User(name,dob,4,pharmacist);
        loginService.addLoginCredentials(user);
        break;

      case 4:
        user = new User(name,dob,5);
        staff = new LabTechnician(id,name,user,dob);
        loginService.addLoginCredentials(user);
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
