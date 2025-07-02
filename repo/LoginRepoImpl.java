package repo;

import java.util.Map;
import java.util.HashMap;
import models.User;

public class LoginRepoImpl implements ILoginRepo{

  private static LoginRepoImpl instance;
  private Map<String, User> userMap; 

  private LoginRepoImpl() {
    userMap = new HashMap<>();
  }

  public static LoginRepoImpl getInstance(){
    if(instance == null){
      instance = new LoginRepoImpl();
    }
    return instance;
  }

  @Override
  public void addLoginCredentials(User user){
    userMap.put(user.getUsername(), user);
  }

  @Override
  public Map<String,User> validateLogin(){
    return userMap;
  }

}
