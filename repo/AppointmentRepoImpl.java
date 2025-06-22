package repo;

import java.util.HashMap;
import java.util.Map;

import repo.IAppointmentRepo;
import models.Patient;
import models.Doctor;

public class AppointmentRepoImpl implements IAppointmentRepo{

  private Map<String, Patient> patientMap = new HashMap<>();
  private Map<String, Doctor> doctorMap = new HashMap<>();

  @Override
  public void savePatient(Patient patient){
    patientMap.put(patient.getPatientName(), patient);
  }

  @Override
  public void saveDoctor(Doctor doctor){
    doctorMap.put(doctor.getName(), doctor);
  }

  @Override
  public Patient getPatientByName(String patientName){
    return patientMap.get(patientName);
  }

  @Override
  public Doctor getDoctorByName(String doctorName){
    return doctorMap.get(doctorName);
  }

}
