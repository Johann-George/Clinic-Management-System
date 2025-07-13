package service;

import models.Consultation;
import models.Patient;

import java.util.List;

public interface IPatientService{

  List<Consultation> viewPrescription(String patientId);
  void registerPatient(Patient patient);
  Patient getPatientByName(String patientName);

}
