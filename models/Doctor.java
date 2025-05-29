package models;

public class Doctor extends Staff{

  private String specialization;

  public Doctor(int id, String name, String specialization, User user, String dob){

    super(id,name,user,dob);
    this.specialization = specialization;

  }

}
