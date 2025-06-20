package app;

import java.util.Scanner;
import service.ILoginService;
import service.IConsultationService;
import service.LoginServiceImpl;
import service.IAdminService;
import service.IAppointmentService;
import service.AdminServiceImpl;
import service.IBillService;
import service.AppointmentServiceImpl;
import service.BillServiceImpl;
import service.ConsultationServiceImpl;
import service.IPatientService;
import service.PatientServiceImpl;
import models.Staff;

//To compile use: javac -d bin Main.java
//To run use: java -cp bin Main
public class Main{

  private static Scanner sc = new Scanner(System.in);

  public void mainDashboard(){

    IAdminService adminService = new AdminServiceImpl();
    ILoginService loginService = new LoginServiceImpl(); 
    IConsultationService consultationService = new ConsultationServiceImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl();
    IBillService billService = new BillServiceImpl();
    IPatientService patientService = new PatientServiceImpl();

    //Admin Login and dashboard
    System.out.println("======Admin Login/Register======");
    System.out.println("Enter Username:");
    String AdminUserName = sc.nextLine();
    System.out.println("Enter Password:");
    String AdminPassword = sc.nextLine();
    int attempt = 0;
    while(attempt!=3){
      if(AdminUserName.equals("admin") && AdminPassword.equals("root")){
        AdminDashboard.runAdminPanel(sc, adminService, loginService);
        break;
      }
      else{
        System.out.println("Incorrect Username or password. Please try again!");
        attempt++;
      }
    }
    if(attempt == 3){
      return;
    }

    //Staff Login and Dashboard
    while(true){
      
      System.out.println("=====Staff Login=====");
      sc.nextLine();
      System.out.println("Enter Username:");
      String username = sc.nextLine();
      System.out.println("Enter Password:");
      String password = sc.nextLine();
      Staff staff = loginService.validateLogin(username,password);
      switch (staff.getRole()) {

        case "Doctor":
          DoctorDashboard.runDoctorPanel(sc, consultationService);
          break;

        case "Receptionist":
          ReceptionistDashboard.runReceptionistPanel(sc, appointmentService, billService);
          break;

        case "Pharmacist":
          System.out.println("Pharmacist dashboard coming soon..");
          break; 

        case "Lab Technician":
          System.out.println("Lab Technician dashboard coming soon..");
          break;

        case "Patient":
          PatientDashboard.runPatientPanel(sc, appointmentService, patientService, billService);
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
