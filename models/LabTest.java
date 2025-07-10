package models;

public class LabTest{

  private String testId;
  private String testName;
  private String status;
  private String result;

  public LabTest(String testId, String testName){
    this.testId = testId;
    this.testName = testName;
  }

  public String getId(){
    return this.testId;
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
