package service;

public interface IBillService{

  void consultationBilling(String patientId, String doctorId);
  void generateDailyCollectionReport();
  void generatePatientBillingHistory(String patientId);

}
