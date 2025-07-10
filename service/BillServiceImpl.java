package service;

import repo.ConsultationRepoImpl;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.PatientRepoImpl;
import repo.IBillRepo;
import repo.BillRepoImpl;
import models.Bill;
import models.Consultation;
import models.Patient;

public class BillServiceImpl implements IBillService{

  private IConsultationRepo consultationRepo;
  private IPatientRepo patientRepo;
  private IBillRepo billRepo;

  public BillServiceImpl(){
    this.consultationRepo = ConsultationRepoImpl.getInstance();
    this.patientRepo = PatientRepoImpl.getInstance();
    this.billRepo = BillRepoImpl.getInstance();
  }

  @Override
  public void consultationBilling(String patientName, String tokenNo){
    
    Patient patient = patientRepo.getPatientByName(patientName);
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo);
    Bill bill = new Bill(patient, consultation, consultation.getAllMedicines(), consultation.getAllLabTests());
    billRepo.saveBill(bill);
    System.out.println("The Total Amount:"+bill.calculateTotalAmount());

  }

  @Override
  public void generateDailyCollectionReport(){

    for(Bill bill : billRepo.getAllBills()){
      System.out.println("Patient Name:"+bill.getPatientName()+"\nTotal Amount:"+bill.getTotalAmount());
      System.out.println();
    }

  }

  @Override
  public void generatePatientBillingHistory(String patientName){

    for(Bill bill : billRepo.getAllBills()){
      if(bill.getPatientName().equals(patientName)){
        System.out.println("Billed Amount:"+bill.getTotalAmount());
      }
    }

  }

}
