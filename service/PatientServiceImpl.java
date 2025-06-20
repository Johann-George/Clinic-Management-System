package service;

import repo.IPatientRepo;
import repo.PatientRepoImpl;
import models.Patient;
import models.Consultation;

import java.time.LocalDate;
import java.util.List;

public class PatientServiceImpl implements IPatientService{

  private IPatientRepo patientRepo;

  public PatientServiceImpl(){
    this.patientRepo = new PatientRepoImpl();
  }

  @Override
  public List<Consultation> viewPrescription(String patientName){

    Patient patient = patientRepo.getPatientByName(patientName);
    return patient.getConsultation();

  }

}
