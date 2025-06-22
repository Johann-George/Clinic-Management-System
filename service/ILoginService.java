package service;

import models.User;

public interface ILoginService{

  void addLoginCredentials(User user);
  User validateLogin(String username,String password);

}
