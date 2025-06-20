package models;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Consultation{

  private String consultationId;
  private String patientId;
  private String diagnosis;
  private LocalDate consultationDate;
  private List<String> medicine;
  private List<String> labTest;

  public Consultation(String patientId, String diagnosis){
    this.consultationId = UUID.randomUUID().toString();
    this.patientId = patientId;
    this.diagnosis = diagnosis;
    this.consultationDate = LocalDate.now();
    this.medicine = new ArrayList<>();
    this.labTest = new ArrayList<>();
  }

  public String getConsultationId(){
    return this.consultationId;
  }

  public String getPatientId(){
    return this.patientId;
  }

  public void addMedicine(List<String> medicine){
    this.medicine.addAll(medicine);
  }

  public void addLabTest(List<String> labTest){
    this.labTest.addAll(labTest);
  }

  public String getDiagnosis(){
    return this.diagnosis;
  }

  public LocalDate getConsultationDate(){
    return this.consultationDate;
  }

  public List<String> getAllMedicines(){
    return this.medicine;
  }

  public List<String> getAllLabTests(){
    return this.labTest;
  }

}
