package repo;

import java.util.Map;
import models.User;

public interface ILoginRepo{

  void addLoginCredentials(User user);
  Map<String, User> validateLogin();

}
