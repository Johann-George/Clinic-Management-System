package repo;

import models.Patient;
import models.Doctor;

public interface IAppointmentRepo{

  void savePatient(Patient patient);
  void saveDoctor(Doctor doctor);
  Patient getPatientByName(String patientName);
  Doctor getDoctorByName(String doctorName);

}
