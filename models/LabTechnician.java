package models;

import service.IDGenerator;

public class LabTechnician extends Staff{

  public LabTechnician(String name, String dob, String username, String password, Integer roleNo){
    super("LAB",name, dob, username, password, roleNo);
  }

}
