package service;

import models.Patient;
import models.Staff;

public interface IAppointmentService{

  void appointmentScheduling(String patientName, String doctorName);
  void registerPatient(Patient patient);
  void registerDoctor(Staff staff);

}
