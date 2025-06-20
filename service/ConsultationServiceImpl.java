package service;

import models.Consultation;
import models.Patient;
import repo.ConsultationRepoImpl;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.PatientRepoImpl;

import java.util.List;

public class ConsultationServiceImpl implements IConsultationService{

  private IConsultationRepo consultationRepo;
  private IPatientRepo patientRepo;

  public ConsultationServiceImpl(){
    this.consultationRepo = new ConsultationRepoImpl();
    this.patientRepo = new PatientRepoImpl();
  }

  @Override
  public Consultation conductConsultation(String patientName, String diagnosis){
    Patient patient = patientRepo.getPatientByName(patientName);
    Consultation consultation = new Consultation(patientName, diagnosis);
    patient.addConsultation(consultation);
    consultationRepo.saveConsultation(consultation);
    return consultation;
  }

  @Override
  public List<Consultation> getPatientHistory(String patientName){
    Patient patient = patientRepo.getPatientByName(patientName);
    return patient.getConsultation();
  }

  @Override
  public void addMedicine(String consultationId, List<String> medicine){
    Consultation consultation = consultationRepo.getConsultationById(consultationId); 
    consultation.addMedicine(medicine);
  }

  @Override
  public void addLabTest(String consultationId, List<String> labTest){
    Consultation consultation = consultationRepo.getConsultationById(consultationId); 
    consultation.addLabTest(labTest);
  }

}
