package repo;

import java.util.Map;
import java.util.HashMap;
import models.User;

public class LoginRepoImpl implements ILoginRepo{

  private Map<String, User> userMap = new HashMap<>();

  @Override
  public void addLoginCredentials(User user){
    userMap.put(user.getUsername(), user);
  }

  @Override
  public Map<String,User> validateLogin(){
    return userMap;
  }

}
