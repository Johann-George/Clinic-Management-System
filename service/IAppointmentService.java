package service;

import models.Patient;

public interface IAppointmentService{

  void appointmentScheduling(String patientId, String doctorId);
  void registerPatient(Patient patient);

}
