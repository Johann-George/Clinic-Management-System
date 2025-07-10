package repo;

import java.util.Map;
import java.util.HashMap;

import models.LabTest;
import repo.ILabTestRepo;

public class LabTestRepoImpl implements ILabTestRepo{

  private static LabTestRepoImpl instance;
  private static Map<String, LabTest> labTests = new HashMap<>();

  public static LabTestRepoImpl getInstance(){
    if(instance == null)
      return instance = new LabTestRepoImpl();
    return instance;
  }

  @Override
  public void saveLabTest(LabTest lt){
    labTests.put(lt.getId(), lt);
  }

  @Override
  public LabTest getLabTestById(String labTestId){
    return labTests.get(labTestId);
  }

}
