package service;

import models.Patient;
import models.Consultation;

import java.util.List;

public interface IConsultationService{

  Consultation conductConsultation(String patientId, String diagnosis);
  List<Consultation> getPatientHistory(String patientId);
  void addMedicine(String consultationId, String medicine);
  void addLabTest(String consultationId, String LabTest);

}
