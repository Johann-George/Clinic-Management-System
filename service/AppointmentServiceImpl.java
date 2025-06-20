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
  public void appointmentScheduling(String patientId, String doctorId){

    Patient patient = appointmentRepo.getPatientById(patientId);
    Doctor doctor = appointmentRepo.getDoctorById(doctorId);
    Appointment a = new Appointment(patient, doctor, appointmentCount++);
    System.out.println("Your Token No:"+a.getTokenNo());
    System.out.println("Your Appointment Time:"+a.getAppointmentTime());

  }

  public void registerPatient(Patient patient){
    appointmentRepo.savePatient(patient);
  }

}
