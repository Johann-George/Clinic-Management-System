package service;

import java.util.List;
import java.util.ArrayList;

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
    if(patient == null){
      throw new PatientNotFoundException("Patient not found");
    }
    Consultation consultation = consultationRepo.getConsultationByTokenNo(tokenNo);
    if(consultation == null){
      throw new ConsultationNotFoundException("Consultation did not happen");
    }
    Bill bill = new Bill(patient, consultation, consultation.getAllMedicines(), consultation.getAllLabTests());
    billRepo.saveBill(bill);
    System.out.println("The Total Amount:"+bill.calculateTotalAmount());

  }

  @Override
  public void generateDailyCollectionReport(){

    List<Bill> billList = new ArrayList<>(billRepo.getAllBills());
    if(billList.isEmpty()){
      System.out.println("No bills were collected today");
      return;
    }
    for(Bill bill : billList){
      System.out.println("Patient Name:"+bill.getPatientName()+"\nTotal Amount:"+bill.getTotalAmount());
      System.out.println();
    }

  }

  @Override
  public void generatePatientBillingHistory(String patientName){
    
    List<Bill> billList = new ArrayList<>(billRepo.getAllBills());
    if(billList.isEmpty()){
      System.out.println("No bills were generated");
      return;
    }
    for(Bill bill : billList){
      if(bill.getPatientName().equals(patientName)){
        System.out.println("Billed Amount:"+bill.getTotalAmount());
      }
    }

  }

}
