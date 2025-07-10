package service;

import models.LabTest;

public interface ILabTestService{

  LabTest getLabTestById(String labTestId);
  void saveLabTest(LabTest labTest);

}
