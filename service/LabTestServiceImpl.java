package service;

import models.LabTest;
import repo.ILabTestRepo;
import repo.LabTestRepoImpl;

public class LabTestServiceImpl implements ILabTestService{

  private ILabTestRepo labTestRepo;

  public LabTestServiceImpl(){
    this.labTestRepo = LabTestRepoImpl.getInstance();
  }

  @Override
  public void saveLabTest(LabTest labTest){
    labTestRepo.saveLabTest(labTest);
  }

  @Override
  public LabTest getLabTestById(String labTestId){
    return labTestRepo.getLabTestById(labTestId);
  }

}
