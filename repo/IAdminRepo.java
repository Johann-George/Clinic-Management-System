package repo;

import java.util.List;
import models.Staff;

public interface IAdminRepo{

  void addStaff(Staff staff);
  Staff getStaffByName(String name);
  void removeStaff(Staff staff);
  List<Staff> getAllStaff();

}
