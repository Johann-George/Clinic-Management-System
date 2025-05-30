package models;

public abstract class Staff{

  protected int id;
  protected String name;
  protected String dob;
  protected String username;
  protected String password;
  protected Role role;

  public Staff(int id, String name, String dob, String username, String password, Role role){
  
    this.id = id;
    this.name = name;
    this.dob = dob;
    this.username = username;
    this.password = password;
    this.role = role;

  }

  public int getId(){
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
    return this.role.roleName;
  }

}
