package service;

public interface IBillService{

  void consultationBilling(String patientName, String doctorName);
  void generateDailyCollectionReport();
  void generatePatientBillingHistory(String patientName);

}
