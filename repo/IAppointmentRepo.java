package repo;

import models.Patient;
import models.Staff;

public interface IAppointmentRepo{

  void savePatient(Patient patient);
  void saveDoctor(Staff staff);
  Patient getPatientByName(String patientName);
  Staff getDoctorByName(String doctorName);

}
