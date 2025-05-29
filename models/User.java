class User{

  private String username;
  private String password;
  private int roleId;
  private Staff staff;//bidirectional link

  public User(String username, String password, int roleId, Staff staff){
    this.username = username;
    this.password = password;
    this.roleId = roleId;
    this.staff = staff;
  }

  public String getUsername(){
    return this.username;
  }

  public String getPassword(){
    return this.password;
  }

  public int getRole(){
    return this.roleId;
  }

  public Staff getStaff(){
    return this.staff;
  }

}
