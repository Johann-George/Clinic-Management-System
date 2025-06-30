package repo;

import java.util.HashMap;
import java.util.Map;

import repo.IAppointmentRepo;
import models.Staff;
import models.Patient;
import models.Doctor;

public class AppointmentRepoImpl implements IAppointmentRepo{

  private Map<String, Patient> patientMap = new HashMap<>();
  private Map<String, Staff> doctorMap = new HashMap<>();

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
