package service;

import repo.ConsultationRepoImpl;
import repo.IConsultationRepo;
import repo.IPatientRepo;
import repo.PatientRepoImpl;
import models.Bill;

import java.util.Scanner;

public class BillServiceImpl implements IBillService{

  private IConsultationRepo consultationRepo;
  private IPatientRepo patientRepo;
  private IBillRepo billRepo;

  public BillServiceImpl(){
    this.consultationRepo = new ConsultationRepoImpl();
    this.patientRepo = new PatientRepoImpl();
    this.billRepo = new BillRepoImpl();
  }

  @Override
  public void consultationBilling(String patientId, String consultationId){
    
    Patient patient = patientRepo.getPatientById(patientId);
    Consultation consultation = consultationRepo.getConsultationById(consultationId);
    Bill bill = new Bill(patient, doctor, consultation.getAllMedicines(), consultation.getAllLabTests());
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
  public void generatePatientBillingHistory(String patientId){

    for(Bill bill : billRepo.getAllBills()){
      if(bill.getPatient().getPatientId().equals(patientId)){
        System.out.println("Billed Amount:"+bill.getTotalAmount());
      }
    }

  }

}
