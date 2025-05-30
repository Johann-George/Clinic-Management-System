package models;

import models.Staff;

public class User{

  private String username;
  private String password;
  private String role;
  private Staff staff;//bidirectional link

  public User(String username, String password, String role, Staff staff){
    this.username = username;
    this.password = password;
    this.role = role;
    this.staff = staff;
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
