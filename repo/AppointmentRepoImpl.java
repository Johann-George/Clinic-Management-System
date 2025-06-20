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
    patientMap.put(patient.getPatientId(), patient);
  }

  @Override
  public void saveDoctor(Doctor doctor){
    doctorMap.put(doctor.getDoctorId(), doctor);
  }

  @Override
  public Patient getPatientById(String patientId){
    return patientMap.get(patientId);
  }

  @Override
  public Doctor getDoctorById(String doctorId){
    return doctorMap.get(doctorId);
  }

}
