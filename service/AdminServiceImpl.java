package service;

import java.util.List;
import repo.IAdminRepo;
import repo.AdminRepoImpl;
import models.Staff;

public class AdminServiceImpl implements IAdminService{

  private IAdminRepo adminRepo;

  public AdminServiceImpl(){
    this.adminRepo = AdminRepoImpl.getInstance();
  }

  @Override
  public void registerStaff(Staff staff){
    adminRepo.addStaff(staff);
  }

  @Override
  public void deleteStaff(String name){
    Staff staff = adminRepo.getStaffByName(name);
    adminRepo.removeStaff(staff);
  }

  @Override
  public List<Staff> displayAllStaff(){
    return adminRepo.getAllStaff();
  }

}
