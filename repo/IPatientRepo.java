package repo;

import models.Consultation;
import models.Patient;

import java.util.List;

public interface IPatientRepo{

  void savePatient(Patient patient);
  Patient getPatientById(String patientId);

}
