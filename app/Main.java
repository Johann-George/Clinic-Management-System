package app;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.time.format.DateTimeParseException;

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
import models.Patient;

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

    while(true){

      System.out.println("\n===== Welcome to Clinic Management System =====");
      System.out.println("1. Admin Login");
      System.out.println("2. Staff Login");
      System.out.println("3. Patient Login");
      System.out.println("4. Patient Registration");
      System.out.println("5. Exit");
      try{
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        
        switch(choice){

          case 1:
            AdminLogin(adminService, loginService, appointmentService);
            break;
          
          case 2:
            staffLogin(consultationService, appointmentService, loginService, patientService, billService, labTestService);
            break;

          case 3:
            patientLogin(loginService, appointmentService, patientService, billService, labTestService);
            break;

          case 4:
            patientRegistration(loginService, appointmentService, patientService);
            break;

          case 5:
            return;

          default:
            System.out.println("Enter a valid input");
            break;

        }
      }
      catch(InputMismatchException e){
        System.out.println("Please enter a number between 1 and 5.");
      }
      catch(Exception e){
        e.printStackTrace();
      } 
    }

  }

  public void patientRegistration(ILoginService loginService, IAppointmentService appointmentService, IPatientService patientService){

    try{
      sc.nextLine();
      System.out.println("Enter the Patient Name:");
      String patientName = sc.nextLine();
      System.out.println("Enter the Contact No:");
      String contactNo = sc.nextLine();
      System.out.println("Enter address:");
      String address = sc.nextLine();
      System.out.println("Enter DOB(dd/mm/yy):");
      String DoB = sc.nextLine();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate dob = null; 
      try{
        dob = LocalDate.parse(DoB, formatter);
      }
      catch(DateTimeParseException e){
        System.out.println("Invalid date format. Please enter DOB in dd/MM/YYYY format.");
      }
      System.out.println("Enter Gender:");
      String gender = sc.nextLine();
      Patient p = new Patient(patientName, contactNo, address, dob, gender);
      User user = new User(patientName, DoB, 5, p);
      loginService.addLoginCredentials(user);
      appointmentService.registerPatient(p);
      patientService.registerPatient(p);
      System.out.println("Patient is registered successfully");
    }
    catch(InputMismatchException e){
      System.out.println("Invalid input entered!");
    }
    catch(NullPointerException e){
      System.out.println("Some required data is missing. Please try again");
    }
    catch(Exception e){
      System.out.println("Some unexpected error occured:"+ e.getMessage());
      e.printStackTrace();
    }
  }

  public void patientLogin(ILoginService loginService, IAppointmentService appointmentService, IPatientService patientService, IBillService billService, ILabTestService labTestService){

    try{
      sc.nextLine();
      System.out.println("=====Patient Login=====");
      System.out.println("Enter Username:");
      String username = sc.nextLine();
      System.out.println("Enter Password:");
      String password = sc.nextLine();
      User user = loginService.validateLogin(username,password);
      if(user != null){
        PatientDashboard.runPatientPanel(sc, appointmentService, patientService, billService, labTestService);
      }
    }
    catch(NullPointerException e){
      System.out.println("Some required data is missing. Please try again");
    }
    catch(Exception e){
      System.out.println("Some unexpected error occured:"+ e.getMessage());
      e.printStackTrace();
    }

  }  

  public void staffLogin(IConsultationService consultationService, IAppointmentService appointmentService, ILoginService loginService, IPatientService patientService, IBillService billService, ILabTestService labTestService){

    try{
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
          PatientDashboard.runPatientPanel(sc, appointmentService, patientService, billService, labTestService);
          break;

        default:
          System.out.println("Enter a valid input");
          break;
      }
    }
    catch(NullPointerException e){
      System.out.println("Some required data is missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("Some unexpected error occured:"+ e.getMessage());
      e.printStackTrace();
    }

  }


  private void AdminLogin(IAdminService adminService, ILoginService loginService, IAppointmentService appointmentService){

      //Admin Login and dashboard
    try{
      sc.nextLine();
      System.out.println("======Admin Login/Register======");
      System.out.println("Enter Username:");
      String AdminUserName = sc.nextLine();
      System.out.println("Enter Password:");
      String AdminPassword = sc.nextLine();
      int attempt = 0;
      while(attempt!=3){
        if(AdminUserName.equals("admin") && AdminPassword.equals("root")){
          AdminDashboard.runAdminPanel(sc, adminService, loginService, appointmentService);
          return;
        }
        else{
          System.out.println("Incorrect Username or password. Please try again!");
          attempt++;
          if(attempt<3){
            System.out.println("Enter Username:");
            AdminUserName = sc.nextLine();
            System.out.println("Enter Password:");
            AdminPassword = sc.nextLine();
          }
        }
      }
      System.out.println("Maximum login attempts reached. Exiting..");
    }
    catch(NullPointerException e){
      System.out.println("Some required data is missing. Please try again.");
    }
    catch(Exception e){
      System.out.println("An unexpected error occured "+e.getMessage());
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
      Main main = new Main();
      main.mainDashboard();
  }

}
