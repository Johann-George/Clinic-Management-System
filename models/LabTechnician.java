package models;

import service.IDGenerator;

public class LabTechnician extends Staff{

  public LabTechnician(String name, String dob, String username, String password, Role role){
    super("LAB",name, dob, username, password, role);
  }

}
