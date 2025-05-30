package service;

import models.Staff;

public interface ILoginService{

  void addLoginCredentials(Staff staff);
  Staff validateLogin(String username,String password);

}
