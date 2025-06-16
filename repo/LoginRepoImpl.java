package repo;

import java.util.Map;
import java.util.HashMap;
import models.Staff;

public class LoginRepoImpl implements ILoginRepo{

  private Map<String, Staff> staffMap = new HashMap<>();

  @Override
  public void addLoginCredentials(Staff staff){
    staffMap.put(staff.getUsername(),staff);
  }

  @Override
  public Map<String,Staff> validateLogin(){
    return staffMap;
  }

}
