package repo;

import models.Consultation;
import models.Patient;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class PatientRepoImpl implements IPatientRepo{

  private Map<String , Patient> personMap = new HashMap<>();

  @Override
  public void savePatient(Patient patient){
    personMap.putIfAbsent(patient.getPatientName(), patient);
  }

  @Override
  public Patient getPatientByName(String patientName){
    return personMap.get(patientName);
  }

}
