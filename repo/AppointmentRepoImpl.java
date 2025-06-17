package repo;

import java.util.HashMap;
import java.util.Map;

import repo.IAppointmentRepo;

pubilc class AppointmentRepo implements IAppointmentRepo{

  private Map<String, Patient> patientMap = new HashMap<>();
  private Map<String, Doctor> doctorMap = new HashMap<>();

  @Override
  void savePatient(Patient patient){
    patientMap.put(patient.getPatientId(), patient);
  }

  @Override
  void saveDoctor(Doctor doctor){
    doctorMap.put(doctor.getDoctorId(), doctor);
  }

  @Override
  Patient getPatientById(String patientId){
    return patientMap.get(patientId);
  }

  @Override
  Doctor getDoctorById(String doctorId){
    return doctorMap.get(doctorId);
  }

}
