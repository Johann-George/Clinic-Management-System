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
  public Consultation getConsultationById(String consultationId){
    return consultationMap.get(consultationId);
  }

  @Override
  public void saveConsultation(Consultation consultation){
    consultationMap.put(consultation.getConsultationId(), consultation);
  }

}
