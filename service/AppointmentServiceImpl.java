package service;

import models.Staff;
import models.Patient;
import models.Doctor;
import models.Appointment;
import repo.IAppointmentRepo;
import repo.AppointmentRepoImpl;
import utils.PatientNotFoundException;
import utils.StaffNotFoundException;

public class AppointmentServiceImpl implements IAppointmentService{

  private IAppointmentRepo appointmentRepo;
  private int appointmentCount = 0;

  public AppointmentServiceImpl(){
    appointmentRepo = AppointmentRepoImpl.getInstance();
  }

  @Override
  public Appointment appointmentScheduling(String patientName, String doctorName){

    Patient patient = appointmentRepo.getPatientByName(patientName);
    if(patient == null){
      throw new PatientNotFoundException("Patient does not exist!");
    }
    Doctor doctor = (Doctor)appointmentRepo.getDoctorByName(doctorName);
    if(doctor == null){
      throw new StaffNotFoundException("Staff does not exist!");
    }
    Appointment a = new Appointment(patient, doctor, appointmentCount++);
    return a;

  }

  public void registerPatient(Patient patient){
    if(patient == null){
      throw new PatientNotFoundException("Patient does not exist!");
    }
    appointmentRepo.savePatient(patient);
  }

  public void registerDoctor(Staff staff){
    if(staff == null){
      throw new StaffNotFoundException("Staff does not exist!");
    }
    appointmentRepo.saveDoctor(staff);
  }

}
