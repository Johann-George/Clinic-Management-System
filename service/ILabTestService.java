package service;

import java.util.List;

import models.LabTest;

public interface ILabTestService{

  LabTest getLabTestById(String labTestId);
  void saveLabTest(LabTest labTest);
  List<LabTest> viewLabTestReports(String patientId);

}
