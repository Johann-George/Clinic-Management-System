package repo;

import models.Staff;

public interface IAdminRepo{

  void addStaff(Staff staff);
  Staff getStaffById(int id);
  void removeStaff(Staff staff);

}
