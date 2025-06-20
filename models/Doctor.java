package models;

import service.IDGenerator;

public class Doctor extends Staff{

  private String specialization;

  public Doctor(String name, String specialization, String dob, String username, String password, Role role){
    super("DOC",name,dob,username,password,role);
    this.specialization = specialization;
  }

  public String getDoctorId(){
    return this.id;
  }

}
