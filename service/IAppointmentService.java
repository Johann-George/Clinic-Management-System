package service;

import models.Patient;
import models.Staff;
import models.Appointment;

public interface IAppointmentService{

  Appointment appointmentScheduling(String patientName, String doctorName);
  void registerPatient(Patient patient);
  void registerDoctor(Staff staff);

}
