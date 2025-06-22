package service;

import models.Patient;
import models.Doctor;
import models.Appointment;
import repo.IAppointmentRepo;
import repo.AppointmentRepoImpl;

public class AppointmentServiceImpl implements IAppointmentService{

  private IAppointmentRepo appointmentRepo;
  private int appointmentCount = 0;

  public AppointmentServiceImpl(){
    this.appointmentRepo = new AppointmentRepoImpl();
  }

  @Override
  public void appointmentScheduling(String patientName, String doctorName){

    Patient patient = appointmentRepo.getPatientByName(patientName);
    Doctor doctor = appointmentRepo.getDoctorByName(doctorName);
    Appointment a = new Appointment(patient, doctor, appointmentCount++);
    System.out.println("Your Token No:"+a.getTokenNo());
    System.out.println("Your Appointment Time:"+a.getAppointmentTime());

  }

  public void registerPatient(Patient patient){
    appointmentRepo.savePatient(patient);
  }

  public void registerDoctor(Doctor doctor){
    appointmentRepo.saveDoctor(doctor);
  }

}
