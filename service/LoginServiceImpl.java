package service;

import models.Staff;
import repo.ILoginRepo;
import repo.LoginRepoImpl;
import java.util.Map;

public class LoginServiceImpl implements ILoginService{

  private ILoginRepo loginRepo;

  public LoginServiceImpl(){
    this.loginRepo = new LoginRepoImpl();
  }

  @Override
  public void addLoginCredentials(Staff staff){
    loginRepo.addLoginCredentials(staff);
  }

  @Override
  public Staff validateLogin(String username, String password){
    for(Map.Entry<String,Staff> validate: (loginRepo.validateLogin()).entrySet()){
      if(username.equals(validate.getKey())){
        Staff staff = validate.getValue();
        if(staff.getPassword().equals(password)){
          return staff;
        }
      }
    }
    return null;
  }

}
