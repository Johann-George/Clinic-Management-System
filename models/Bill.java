package models;

import java.util.List;

public class Bill{

  private Patient patient;
  private Consultation consultation;
  private double consultationFee;
  private List<String> labTest;
  private List<String> medicine;
  private double totalAmount;

  public Bill(Patient patient, Consultation consultation, List<String> labTest, List<String> medicine){
    this.patient = patient;
    this.consultation = consultation;
    this.consultationFee = 500;
    this.labTest = labTest;
    this.medicine = medicine;
    this.totalAmount = calculateTotalAmount();
  }

  public double calculateTotalAmount(){
    for(String m: medicine){
      totalAmount+=100;
    }
    for(String l: labTest){
      totalAmount+=100;
    }
    return totalAmount;
  }

  public double getTotalAmount(){
    return this.totalAmount;
  }

  public String getPatientName(){
    return this.patient.getPatientName();
  }

  public String getPatientId(){
    return this.patient.getPatientId();
  }

}
