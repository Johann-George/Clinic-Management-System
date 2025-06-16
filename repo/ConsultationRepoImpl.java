package repo;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import models.Consultation;

public class ConsultationRepoImpl implements IConsultationRepo{

  private Map<String, Consultation> consultationMap = new HashMap<>();
  
  @Override
  public Consultation getConsultationById(String consultationId){
    return consultationMap.get(consultationId);
  }

  @Override
  public void saveConsultation(Consultation consultation){
    consultationMap.put(consultation.getConsultationId(), consultation);
  }

}
