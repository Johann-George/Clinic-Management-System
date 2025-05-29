package service;

import models.User;
import repo.ILoginRepo;
import repo.LoginRepoImpl;
import java.util.Map;

public class LoginServiceImpl implements ILoginService{

  private ILoginRepo loginRepo;

  public LoginServiceImpl(){
    this.loginRepo = new LoginRepoImpl();
  }

  @Override
  public void addLoginCredentials(User user){
    adminRepo.addLoginCredentials(user);
  }

  @Override
  public User validateLogin(String username, String password){
    for(Map.Entry<String,User> validate: (loginRepo.validateLogin()).entrySet()){
      if(username.equals(validate.getKey())){
        User user = validate.getValue().get(username);
        if(user.getPassword().equals(password)){
          return user;
        }
      }
    }
    return null;
  }

}
