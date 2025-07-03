package service;

import models.Consultation;
import models.Patient;
import repo.ConsultationRepoImpl;
import repo.AppointmentRepoImpl;
import repo.IAppointmentRepo;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.PatientRepoImpl;

import java.util.List;

public class ConsultationServiceImpl implements IConsultationService{

  private IConsultationRepo consultationRepo;
  private IAppointmentRepo appointmentRepo;

  public ConsultationServiceImpl(){
    this.consultationRepo = ConsultationRepoImpl.getInstance();
    this.appointmentRepo= AppointmentRepoImpl.getInstance();
  }

  @Override
  public Consultation conductConsultation(String tokenNo, String patientName, String diagnosis){
    Patient patient = appointmentRepo.getPatientByName(patientName);
    Consultation consultation = new Consultation(patientName, diagnosis);
    patient.addConsultation(consultation);
    consultationRepo.saveConsultation(tokenNo, consultation);
    return consultation;
  }

  @Override
  public List<Consultation> getPatientHistory(String patientName){
    Patient patient = appointmentRepo.getPatientByName(patientName);
    return patient.getConsultation();
  }

  @Override
  public void addMedicine(String tokenNo, List<String> medicine){
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo); 
    consultation.addMedicine(medicine);
  }

  @Override
  public void addLabTest(String tokenNo, List<String> labTest){
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo); 
    consultation.addLabTest(labTest);
  }

}
