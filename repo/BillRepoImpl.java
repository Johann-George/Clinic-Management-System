package repo;

import java.util.ArrayList;
import java.util.List;

import models.Bill;

public class BillRepoImpl implements IBillRepo{

  private static BillRepoImpl instance;
  private List<Bill> billList; 

  private BillRepoImpl() {
    billList = new ArrayList<>();
  }

  public static BillRepoImpl getInstance(){
    if(instance == null){
      instance = new BillRepoImpl();
    }
    return instance;
  }

  @Override
  public void saveBill(Bill bill){
    billList.add(bill);
  }

  @Override
  public List<Bill> getAllBills(){
    return billList;
  }

}
