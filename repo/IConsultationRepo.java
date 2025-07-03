package repo;

import models.Consultation;

public interface IConsultationRepo{

  Consultation getConsultationById(String consultationId);
  void saveConsultation(String tokenNo, Consultation consultation);
  Consultation getConsultationByTokenNo(String tokenNo);

}
