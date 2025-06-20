package repo;

import java.util.List;
import java.util.ArrayList;
import models.Staff;

public class AdminRepoImpl implements IAdminRepo{

  private List<Staff> staffList= new ArrayList<>();

  @Override
  public void addStaff(Staff staff){
    staffList.add(staff);
  }

  @Override
  public Staff getStaffById(String id){
    for(Staff s: staffList){
      if(s.getId().equals(id)){
        return s;
      }
    }
    return null;
  }

  @Override
  public void removeStaff(Staff staff){
    staffList.remove(staff);
  }

  @Override
  public List<Staff> getAllStaff(){
    return staffList;
  }

}
