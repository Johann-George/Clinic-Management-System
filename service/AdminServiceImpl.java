package service;

import java.util.List;
import java.util.ArrayList;
import repo.IAdminRepo;
import repo.AdminRepoImpl;
import models.Staff;

public class AdminServiceImpl implements IAdminService{

  private IAdminRepo adminRepo;

  public AdminServiceImpl(){

    this.adminRepo = new AdminRepoImpl();

  }

  @Override
  public void registerStaff(Staff staff){
    adminRepo.addStaff(staff);
  }

  @Override
  public void deleteStaff(String id){
    Staff staff = adminRepo.getStaffById(id);
    adminRepo.removeStaff(staff);
  }

  @Override
  public List<Staff> displayAllStaff(){
    return adminRepo.getAllStaff();
  }

}
