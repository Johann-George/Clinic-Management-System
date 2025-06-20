package service;

import models.Consultation;

import java.util.List;

public interface IPatientService{

  List<Consultation> viewPrescription(String patientId);

}
