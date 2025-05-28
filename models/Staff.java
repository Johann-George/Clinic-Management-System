package models;

public abstract class Staff{

  protected int id;
  protected String name;
  protected String role;

  public Staff(int id, String name, String role){
  
    this.id = id;
    this.name = name;
    this.role = role;

  }

}
