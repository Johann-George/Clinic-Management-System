package service;

import java.util.HashMap;
import java.util.Map;

public class IDGenerator{

  private static Map<String, Integer> counters = new HashMap<>();

  static {
    counters.put("PAT", 0);
    counters.put("DOC", 0);
    counters.put("PHA", 0);
    counters.put("LAB", 0);
    counters.put("REC", 0);
  }

  public static String generateID(String roleCode){
    int count = counters.getOrDefault(roleCode, 0) + 1;
    counters.put(roleCode, count);
    return roleCode + String.format("%04d", count);
  }

}
