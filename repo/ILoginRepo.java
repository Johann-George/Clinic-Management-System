package repo;

import java.util.Map;
import models.Staff;

public interface ILoginRepo{

  void addLoginCredentials(Staff staff);
  Map<String,Staff> validateLogin();

}
