package repo;

import java.util.ArrayList;
import java.util.List;

import repo.ConsultationRepoImpl;
import models.Bill;

public class BillRepoImpl implements IBillRepo{

  private List<Bill> billList = new ArrayList<>();

  @Override
  public void saveBill(Bill bill){
    billList.add(bill);
  }

  @Override
  public List<Bill> getAllBills(){
    return billList;
  }

}
