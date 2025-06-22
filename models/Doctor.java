package models;

import service.IDGenerator;

public class Doctor extends Staff{

  private String specialization;

  public Doctor(String name, String specialization, String dob, String username, String password, Integer roleNo){
    super("DOC",name,dob,username,password,roleNo);
    this.specialization = specialization;
  }

  public String getDoctorId(){
    return id;
  }

  public String getDoctorName(){
    return this.name;
  }

}
