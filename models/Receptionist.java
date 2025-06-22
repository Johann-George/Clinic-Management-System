package models;

import service.IDGenerator;

public class Receptionist extends Staff{

  public Receptionist(String name, String dob, String username, String password, Integer roleNo){
    super("REC", name, dob, username, password, roleNo);
  }

}
