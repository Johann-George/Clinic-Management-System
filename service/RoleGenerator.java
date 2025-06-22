package service;

import java.util.Map;
import java.util.HashMap;

public class RoleGenerator{

  private static Map<Integer, String> roleMap = new HashMap<>();

  static{

    roleMap.put(1,"Doctor");
    roleMap.put(2,"Receptionist");
    roleMap.put(3,"Pharmacist");
    roleMap.put(4,"Lab Technician");
    roleMap.put(5,"Patient");

  }

  public static String getRole(int roleNo){
    return roleMap.get(roleNo);
  }

}
