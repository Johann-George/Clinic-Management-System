package service;

import models.Staff;
import models.Patient;
import models.Doctor;
import models.Appointment;
import repo.IAppointmentRepo;
import repo.AppointmentRepoImpl;

public class AppointmentServiceImpl implements IAppointmentService{

  private IAppointmentRepo appointmentRepo;
  private int appointmentCount = 0;

  public AppointmentServiceImpl(){
    appointmentRepo = AppointmentRepoImpl.getInstance();
  }

  @Override
  public Appointment appointmentScheduling(String patientName, String doctorName){

    Patient patient = appointmentRepo.getPatientByName(patientName);
    Doctor doctor = (Doctor)appointmentRepo.getDoctorByName(doctorName);
    Appointment a = new Appointment(patient, doctor, appointmentCount++);
    return a;

  }

  public void registerPatient(Patient patient){
    appointmentRepo.savePatient(patient);
  }

  public void registerDoctor(Staff staff){
    appointmentRepo.saveDoctor(staff);
  }

}
