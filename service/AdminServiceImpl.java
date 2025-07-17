package service;

import java.util.List;
import repo.IAdminRepo;
import repo.AdminRepoImpl;
import models.Staff;
import utils.StaffNotFoundException;

public class AdminServiceImpl implements IAdminService{

  private IAdminRepo adminRepo;

  public AdminServiceImpl(){
    this.adminRepo = AdminRepoImpl.getInstance();
  }

  @Override
  public void registerStaff(Staff staff){
    //checking if staff obj is null
    if(staff == null){
      throw new StaffNotFoundException("Staff not found");
    }

    //Checking for duplicates
    Staff existingStaff = adminRepo.getStaffByName(staff.getName());
    if(existingStaff != null){
      throw new IllegalArgumentException("Staff with name "+staff.getName()+ "already exists");
    }

    adminRepo.addStaff(staff);
  }

  @Override
  public void deleteStaff(String name){
    //check if staff exists
    Staff staff = adminRepo.getStaffByName(name);
    if(staff == null){
      throw new StaffNotFoundException("Staff not found");
    }

    adminRepo.removeStaff(staff);
  }

  @Override
  public List<Staff> displayAllStaff(){
    return adminRepo.getAllStaff();
  }

}
