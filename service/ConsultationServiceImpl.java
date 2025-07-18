package service;

import models.Consultation;
import models.Patient;
import repo.ConsultationRepoImpl;
import repo.AppointmentRepoImpl;
import repo.IAppointmentRepo;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.PatientRepoImpl;
import utils.PatientNotFoundException;
import utils.ConsultationNotFoundException;

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
    if(patient == null){
      throw new PatientNotFoundException("Patient does not exist");
    }
    Consultation consultation = new Consultation(patient.getPatientId(), diagnosis);
    if(consultation == null){
      throw new ConsultationNotFoundException("Consultation never happened");
    }
    patient.addConsultation(consultation);
    consultationRepo.saveConsultation(tokenNo, consultation);
    return consultation;
  }

  @Override
  public List<Consultation> getPatientHistory(String patientName){
    Patient patient = appointmentRepo.getPatientByName(patientName);
    if(patient == null){
      throw new PatientNotFoundException("Patient does not exist");
    }
    return patient.getConsultation();
  }

  @Override
  public void addMedicine(String tokenNo, List<String> medicine){
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo); 
    if(consultation == null){
      throw new ConsultationNotFoundException("Consultation never happened");
    }
    consultation.addMedicine(medicine);
  }

  @Override
  public void addLabTest(String tokenNo, List<String> labTest){
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo); 
    if(consultation == null){
      throw new ConsultationNotFoundException("Consultation never happened");
    }
    consultation.addLabTest(labTest);
  }

  @Override
  public Consultation getConsultationByTokenNo(String tokenNo){
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo);
    if(consultation == null){
      throw new ConsultationNotFoundException("Consultation never happened");
    }
    return consultation;
  }

}
