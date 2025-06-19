package repo;

import models.Consultation;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.List;

public interface IConsultationRepo{

  Consultation getConsultationById(String consultationId);
  void saveConsultation(Consultation consultation);

}
