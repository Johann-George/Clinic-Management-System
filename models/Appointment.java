package models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment{

  private String token;
  private Patient patient;
  private Doctor doctor;
  private LocalDate date;
  private LocalTime time;

  public Appointment(Patient patient, Doctor doctor, int appointmentCount){
    this.patient = patient;
    this.doctor = doctor;
    this.date = LocalDate.now();
    this.token = generateToken(doctor.getId(), date, appointmentCount);
    this.time = generateTimeSlot(appointmentCount);
  }

  private String generateToken(String doctorId, LocalDate date, int tokenNo){
    return doctorId+"-"+date.toString().replaceAll("-","")+"-"+String.format("%03d", tokenNo);
  }

  private LocalTime generateTimeSlot(int count){
    LocalTime startTime = LocalTime.of(9, 0);
    return startTime.plusMinutes(15L * count);
  }

  public String getTokenNo(){
    return this.token;
  }

  public LocalTime getAppointmentTime(){
    return this.time;
  }

}
