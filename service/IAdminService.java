package service;

import models.Staff;

public interface IAdminService{

  void registerStaff(Staff staff);
  void deleteStaff(int id);

}
