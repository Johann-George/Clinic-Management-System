package repo;

import models.Consultation;
import models.Patient;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class PatientRepoImpl implements IPatientRepo{

  private Map<Integer, Patient> personMap = new HashMap<>();

  @Override
  public void savePatient(Patient patient){
    personMap.putIfAbsent(patient.getPatientId(), patient);
  }

  @Override
  public Patient getPatientById(String patientId){
    return personMap.get(patientId);
  }

}
