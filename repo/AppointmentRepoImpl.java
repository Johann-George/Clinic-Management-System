package repo;

import java.util.HashMap;
import java.util.Map;

import models.Staff;
import models.Patient;

public class AppointmentRepoImpl implements IAppointmentRepo{

  private static AppointmentRepoImpl instance;

  private Map<String, Patient> patientMap; 
  private Map<String, Staff> doctorMap; 

  private AppointmentRepoImpl() {
    patientMap = new HashMap<>();
    doctorMap = new HashMap<>();
  }

  public static AppointmentRepoImpl getInstance(){
    if(instance == null){
      instance = new AppointmentRepoImpl();
    }
    return instance;
  }

  @Override
  public void savePatient(Patient patient){
    patientMap.put(patient.getPatientName(), patient);
  }

  @Override
  public void saveDoctor(Staff staff){
    doctorMap.put(staff.getName(), staff);
  }

  @Override
  public Patient getPatientByName(String patientName){
    return patientMap.get(patientName);
  }

  @Override
  public Staff getDoctorByName(String doctorName){
    return doctorMap.get(doctorName);
  }

}
