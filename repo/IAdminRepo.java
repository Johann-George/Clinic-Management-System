package repo;

import java.util.List;
import models.Staff;

public interface IAdminRepo{

  void addStaff(Staff staff);
  Staff getStaffById(int id);
  void removeStaff(Staff staff);
  List<Staff> getAllStaff();

}
