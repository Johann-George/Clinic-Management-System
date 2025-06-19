package service;

import java.util.Scanner;

public interface IBillService{

  void consultationBilling(String patientId, String doctorId);
  void generateDailyCollectionReport();
  void generatePatientBillingHistory(String patientId);

}
