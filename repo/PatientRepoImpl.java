package repo;

import models.Consultation;
import models.Patient;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class PatientRepoImpl implements IPatientRepo{

  private static PatientRepoImpl instance;
  private Map<String , Patient> personMap; 

  private PatientRepoImpl() {
    personMap = new HashMap<>();
  }

  public static PatientRepoImpl getInstance(){
    if(instance == null){
      instance = new PatientRepoImpl();
    }
    return instance;
  }

  @Override
  public void savePatient(Patient patient){
    personMap.putIfAbsent(patient.getPatientName(), patient);
  }

  @Override
  public Patient getPatientByName(String patientName){
    return personMap.get(patientName);
  }

}
