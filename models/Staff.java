package models;

public abstract class Staff{

  protected int id;
  protected String name;
  protected User user;
  protected String dob;

  public Staff(int id, String name, User user, String dob){
  
    this.id = id;
    this.name = name;
    this.user = user;
    this.dob = dob;

  }

  public int getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getRole(){
    return this.user.getRole();
  }

  public String getDob(){
    return this.dob;
  }

}
