package models;

public class LabTest{

  private String testId;
  private String patientId;
  private String testName;
  private String status;
  private String result;

  public LabTest(String testId, String testName, String patientId){
    this.testId = testId;
    this.testName = testName;
    this.patientId = patientId;
  }

  public String getId(){
    return this.testId;
  }

  public String getPatientId(){
    return this.patientId;
  }

  public void setStatus(String status){
    this.status = status;
  }

  public String getStatus(){
    return this.status;
  }

  public void setResult(String result){
    this.result = result;
  }

  public String getResult(){
    return this.result;
  }

  public String getName(){
    return this.testName;
  }
  
}
