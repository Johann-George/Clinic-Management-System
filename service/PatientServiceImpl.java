package service;

import repo.IPatientRepo;
import repo.PatientRepoImpl;
import models.Patient;

public class PatientServiceImpl{

  private IPatientRepo patientRepo;

  PatientServiceImpl(){
    this.patientRepo = new PatientRepoImpl();
  }

  @Override
  public List<Consultation> viewPrescriptions(String patientId, LocalDate date){

    Patient patient = patientRepo.getPatientById(patientId);
    List<Consultation> consultation = patient.getConsultation();
    consultationRepo.getConsultationByDate(date);

  }

}
