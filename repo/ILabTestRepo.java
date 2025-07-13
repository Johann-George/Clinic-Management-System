package repo;

import java.util.List;

import models.LabTest;

public interface ILabTestRepo{

  void saveLabTest(LabTest labTest);
  LabTest getLabTestById(String labTestId);
  List<LabTest> getLabTestByPatientId(String patientId);

}
