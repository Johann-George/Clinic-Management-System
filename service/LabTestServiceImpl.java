package service;

import java.util.List;
import java.util.ArrayList;

import models.LabTest;
import repo.ILabTestRepo;
import repo.LabTestRepoImpl;
import utils.LabTestNotFoundException;

public class LabTestServiceImpl implements ILabTestService{

  private ILabTestRepo labTestRepo;

  public LabTestServiceImpl(){
    this.labTestRepo = LabTestRepoImpl.getInstance();
  }

  @Override
  public void saveLabTest(LabTest labTest){
    if(labTest == null){
      throw new LabTestNotFoundException("Lab Test does not exist");
    }
    labTestRepo.saveLabTest(labTest);
  }

  @Override
  public LabTest getLabTestById(String labTestId){
    LabTest lt = labTestRepo.getLabTestById(labTestId);
    if(lt == null){
      throw new LabTestNotFoundException("Lab Test Id is invalid");
    }
    return lt;
  }

  @Override
  public List<LabTest> viewLabTestReports(String patientId){
    List<LabTest> lt = new ArrayList<>(labTestRepo.getLabTestByPatientId(patientId));
    if(lt.isEmpty()){
      throw new LabTestNotFoundException("The patient does not have any lab tests.");
    }
    return lt;
  }

}
