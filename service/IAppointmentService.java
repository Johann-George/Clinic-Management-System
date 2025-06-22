package service;

import models.Patient;
import models.Doctor;

public interface IAppointmentService{

  void appointmentScheduling(String patientName, String doctorName);
  void registerPatient(Patient patient);
  void registerDoctor(Doctor doctor);

}
