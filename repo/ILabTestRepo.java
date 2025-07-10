package repo;

import models.LabTest;

public interface ILabTestRepo{

  void saveLabTest(LabTest labTest);
  LabTest getLabTestById(String labTestId);

}
