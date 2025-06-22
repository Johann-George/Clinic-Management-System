package models;

import service.IDGenerator;
import service.RoleGenerator;

public abstract class Staff{

  protected String id;
  protected String name;
  protected String dob;
  protected String username;
  protected String password;
  protected String role;

  public Staff(String id, String name, String dob, String username, String password, Integer roleNo){
  
    this.id = IDGenerator.generateID(id);
    this.name = name;
    this.dob = dob;
    this.username = username;
    this.password = password;
    this.role = RoleGenerator.getRole(roleNo);

  }

  public String getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getDob(){
    return this.dob;
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

}
