package repo;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import models.Consultation;

public class ConsultationRepoImpl implements IConsultationRepo{

  private static ConsultationRepoImpl instance;
  private Map<String, Consultation> consultationMap;
  
  private ConsultationRepoImpl() {
    consultationMap = new HashMap<>();
  }

  public static ConsultationRepoImpl getInstance(){
    if(instance == null){
      instance = new ConsultationRepoImpl();
    }
    return instance;
  }

  @Override
  public Consultation getConsultationById(String consultationId) {
    for (Consultation consultation : consultationMap.values()) {
      if (consultation.getConsultationId().equals(consultationId)) {
        return consultation;
      }
    }
    return null; // or throw an exception if not found
  }

  @Override
  public Consultation getConsultationByTokenNo(String tokenNo) {
    for(Map.Entry<String, Consultation> c : consultationMap.entrySet()){
      System.out.println("Token No:"+c.getKey()+" Consultation medicines:"+ c.getValue());
    }
    return consultationMap.get(tokenNo);
  }

  @Override
  public void saveConsultation(String tokenNo, Consultation consultation){
    consultationMap.put(tokenNo, consultation);
  }

}
