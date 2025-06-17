package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Consultation;

public class Patient{

  private int patient_id;
  private String name;
  private String contactNo;
  private String address;
  private LocalDate dob; 
  private String gender;
  private List<Consultation> consultation;

  public Patient(int patient_id, String name, String contactNo, String address, LocalDate dob, String gender){

    this.patient_id = patient_id;
    this.name = name;
    this.contactNo = contactNo;
    this.address = address;
    this.dob = dob;
    this.gender = gender;
    this.consultation = new ArrayList<>();

  }

  public int getPatientId(){
    return this.patient_id;
  }

  public String getPatientName(){
    return this.name;
  }

  public List<Consultation> getConsultation(){
    return this.consultation;
  }

  public void addConsultation(Consultation consultation){
    this.consultation.add(consultation);
  }

}
