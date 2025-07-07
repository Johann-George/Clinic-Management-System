package service;

import java.util.Map;
import java.util.HashMap;

public class InventoryStocks{

  private static Map<String, Integer> stock = new HashMap<>();

  static{
    stock.put("Paracetamol", 100);
    stock.put("Pain killer", 100);
    stock.put("Dolo", 50);
    stock.put("ORS", 67);
    stock.put("Cetrizine", 57);
  }

  public static int getInventoryStocks(String medicine){
    int count = stock.getOrDefault(medicine, 0);
    if(count>0){
      stock.put(medicine,count-1);
    }
    return count;
  }

  public static Map<String, Integer> getAllInventoryStocks(){
    return stock;
  }

}
