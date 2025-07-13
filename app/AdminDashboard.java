package app;

import java.util.Scanner;
import models.User;
import models.Staff;
import models.Doctor;
import models.Receptionist;
import models.Pharmacist;
import models.LabTechnician;
import service.AdminServiceImpl;
import service.IAdminService;
import service.ILoginService;
import service.LoginServiceImpl;
import service.IAppointmentService;

public class AdminDashboard{

  public static void runAdminPanel(Scanner sc,IAdminService adminService, ILoginService loginService, IAppointmentService appointmentService){

    while(true){
    
      System.out.println("1.Add Staff\n2.Delete Staff\n3.Display All Staff\n4.Exit");
      System.out.println("Enter choice:");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          addStaff(sc,adminService,loginService, appointmentService);
          break;

        case 2:
          deleteStaff(sc,adminService);
          break;
      
        case 3:
          for(Staff s : adminService.displayAllStaff()){
            System.out.println("Staff ID:"+s.getId()+"\t\tStaff Name:"+s.getName()+"\t\tStaff Role:"+s.getRole());
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

  public static void addStaff(Scanner sc,IAdminService adminService,ILoginService loginService, IAppointmentService appointmentService){

    System.out.println("===========================");
    System.out.println("1.Doctor\n2.Receptionist\n3.Pharmacist\n4.Lab Technician");
    System.out.println("Enter choice:");
    int choice = sc.nextInt();
    Staff staff = null;
    User user = null;
    sc.nextLine();
    System.out.println("Enter name:");
    String name = sc.nextLine();
    System.out.println("Enter DOB(format : dd/mm/yyyy):");
    String dob = sc.nextLine();

    switch (choice) {
      case 1:
        System.out.println("Enter specialization:");
        String spec = sc.nextLine();
        staff = new Doctor(name,spec,dob,name,dob,choice);
        user = new User(name, dob, choice, staff);
        loginService.addLoginCredentials(user);
        appointmentService.registerDoctor(staff);
        break;

      case 2:
        staff = new Receptionist(name,dob,name,dob,choice);
        user = new User(name, dob, choice, staff);
        loginService.addLoginCredentials(user);
        break;

      case 3:
        staff = new Pharmacist(name,dob,name,dob,choice);
        user = new User(name, dob, choice, staff);
        loginService.addLoginCredentials(user);
        break;

      case 4:
        staff = new LabTechnician(name,dob,name,dob,choice);
        user = new User(name, dob, choice, staff);
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

    System.out.println("Enter the Name:");
    String name = sc.nextLine();
    adminService.deleteStaff(name);
    System.out.println("Staff is removed successfully!");

  } 

}
