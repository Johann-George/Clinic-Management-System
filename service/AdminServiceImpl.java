import repo.IAdminRepo;
import repo.AdminRepoImpl;

public class AdminServiceImpl implements IAdminService{

  private IAdminRepo adminRepo;

  public AdminServiceImpl(AdminRepoImpl adminRepo){

    this.adminRepo = adminRepo;

  }

  @Override
  public void registerStaff(Staff staff){
    adminRepo.addStaff(staff);
  }

  @Override
  public void deleteStaff(Staff staff){
    adminRepo.removeStaff(staff);
  }

}
