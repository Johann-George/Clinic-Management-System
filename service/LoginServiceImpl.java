package service;

import models.Staff;
import models.User;
import repo.ILoginRepo;
import repo.LoginRepoImpl;
import utils.UserNotFoundException;

import java.util.Map;

public class LoginServiceImpl implements ILoginService{

  private ILoginRepo loginRepo;

  public LoginServiceImpl(){
    this.loginRepo = LoginRepoImpl.getInstance();
  }

  @Override
  public void addLoginCredentials(User user){
    if(user == null){
      throw new UserNotFoundException("User does not exist.");
    }
    loginRepo.addLoginCredentials(user);
  }

  @Override
  public User validateLogin(String username, String password){
    if(loginRepo.validateLogin().isEmpty()){
      System.out.println("No Staff has been added!");
    }
    for(Map.Entry<String, User> validate: loginRepo.validateLogin().entrySet()){
      if(username.equals(validate.getKey())){
        User user = validate.getValue();
        if(user.getPassword().equals(password)){
          return user;
        }
      }
    }
    return null;
  }

}
