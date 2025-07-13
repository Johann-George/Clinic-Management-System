package service;

import repo.IPatientRepo;
import repo.PatientRepoImpl;
import models.Patient;
import models.Consultation;

import java.util.List;

public class PatientServiceImpl implements IPatientService{

  private IPatientRepo patientRepo;

  public PatientServiceImpl(){
    this.patientRepo = PatientRepoImpl.getInstance();
  }

  @Override
  public List<Consultation> viewPrescription(String patientName){

    Patient patient = patientRepo.getPatientByName(patientName);
    return patient.getConsultation();

  }

  @Override
  public void registerPatient(Patient patient){
    patientRepo.savePatient(patient);
  }

  @Override
  public Patient getPatientByName(String patientName){
    return patientRepo.getPatientByName(patientName);
  }

}
