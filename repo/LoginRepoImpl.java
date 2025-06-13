package repo;

import java.util.Map;
import java.util.HashMap;
import models.Staff;

public class LoginRepoImpl implements ILoginRepo{

  private Map<String, Staff> staffMap = new HashMap<>();

  @Override
  public void addLoginCredentials(Staff staff){
    staffMap.put(staff.getUsername(),staff);
    System.out.println("Entered here");
  }

  @Override
  public Map<String,Staff> validateLogin(){
    return staffMap;
  }

}
