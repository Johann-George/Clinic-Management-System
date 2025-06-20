package service;

import java.util.List;
import models.Staff;

public interface IAdminService{

  void registerStaff(Staff staff);
  void deleteStaff(String id);
  List<Staff> displayAllStaff();

}
