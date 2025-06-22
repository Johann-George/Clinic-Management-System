package models;

import service.IDGenerator;

public class Pharmacist extends Staff{

  public Pharmacist(String name, String dob, String username, String password, Integer roleNo){
    super("PHA",name, dob, username, password, roleNo);
  }

}
