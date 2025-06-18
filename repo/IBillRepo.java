package repo;

import models.Bill;

import java.util.List;

public interface IBillRepo{

  void saveBill(Bill bill);
  List<Bill> getAllBills();

}
