package models;

import models.Staff;
import service.RoleGenerator;
import models.Patient;

public class User{

  private String username;
  private String password;
  private String role;
  private Staff staff;
  private Patient patient;

  public User(String username, String password, Integer roleNo, Staff staff){
    this.username = username;
    this.password = password;
    this.role = RoleGenerator.getRole(roleNo);
    this.staff = staff;
  }

  public User(String username, String password, Integer roleNo, Patient patient){
    this.username = username;
    this.password = password;
    this.role = RoleGenerator.getRole(roleNo);
    this.patient = patient;
  }

  public String getUsername(){
    return this.username;
  }

  public String getPassword(){
    return this.password;
  }

  public String getRole(){
    return this.role;
  }

  public Staff getStaff(){
    return this.staff;
  }

}
