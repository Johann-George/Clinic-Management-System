package service;

import models.Patient;
import models.Consultation;

import java.util.List;

public interface IConsultationService{

  Consultation conductConsultation(String patientName, String diagnosis);
  List<Consultation> getPatientHistory(String patientName);
  void addMedicine(String consultationId, List<String> medicine);
  void addLabTest(String consultationId, List<String> LabTest);

}
