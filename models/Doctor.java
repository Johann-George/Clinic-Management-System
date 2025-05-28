package models;

public class Doctor extends Staff{

  private String specialization;

  public Doctor(int id, String name, String specialization){

    super(id,name,"Doctor");
    this.specialization = specialization;

  }

}
