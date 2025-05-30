package models;

public class Doctor extends Staff{

  private String specialization;

  public Doctor(int id, String name, String specialization, String dob, String username, String password, Role role){

    super(id,name,dob,username,password,role);
    this.specialization = specialization;

  }

}
