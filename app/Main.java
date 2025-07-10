package app;

import java.util.Scanner;
import repo.IAdminRepo;
import repo.ILoginRepo;
import repo.IAppointmentRepo;
import repo.IBillRepo;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.LoginRepoImpl;
import repo.PatientRepoImpl;
import repo.AdminRepoImpl;
import repo.AppointmentRepoImpl;
import repo.BillRepoImpl;
import repo.ConsultationRepoImpl;
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
import service.ILabTestService;
import service.LabTestServiceImpl;
import models.User;

//To compile use: javac -d bin app/Main.java
//To run use: java -cp bin app/Main
public class Main{

  private static Scanner sc = new Scanner(System.in);

  public void mainDashboard(){

    // Initialize services
    IAdminService adminService = new AdminServiceImpl();
    ILoginService loginService = new LoginServiceImpl(); 
    IConsultationService consultationService = new ConsultationServiceImpl();
    IAppointmentService appointmentService = new AppointmentServiceImpl();
    IBillService billService = new BillServiceImpl();
    IPatientService patientService = new PatientServiceImpl();
    ILabTestService labTestService = new LabTestServiceImpl();

    //Admin Login and dashboard
    System.out.println("======Admin Login/Register======");
    System.out.println("Enter Username:");
    String AdminUserName = sc.nextLine();
    System.out.println("Enter Password:");
    String AdminPassword = sc.nextLine();
    int attempt = 0;
    while(attempt!=3){
      if(AdminUserName.equals("admin") && AdminPassword.equals("root")){
        AdminDashboard.runAdminPanel(sc, adminService, loginService, appointmentService);
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
      
      sc.nextLine();
      System.out.println("=====Staff Login=====");
      System.out.println("Enter Username:");
      String username = sc.nextLine();
      System.out.println("Enter Password:");
      String password = sc.nextLine();
      User user = loginService.validateLogin(username,password);
      switch (user.getRole()) {

        case "Doctor":
          DoctorDashboard.runDoctorPanel(sc, consultationService);
          break;

        case "Receptionist":
          ReceptionistDashboard.runReceptionistPanel(sc, appointmentService, billService, loginService, patientService);
          break;

        case "Pharmacist":
          PharmacistDashboard.runPharmacistPanel(sc,consultationService, billService);
          break;

       case "Lab Technician":
          LabTechnicianDashboard.runLabTechnicianPanel(sc, consultationService, labTestService);
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
