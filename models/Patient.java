package models;

import java.time.LocalDate;

public class Patient{

  private int patient_id;
  private String name;
  private String contact;
  private String address;
  private LocalDate dob; 
  private String gender;

  public Patient(int patient_id, String name, String contact, String address, LocalDate dob, String gender){

    this.patient_id = patient_id;
    this.name = name;
    this.contact = contact;
    this.address = address;
    this.dob = dob;
    this.gender = gender;

  }

}
