package utils;

public class PatientNotFoundException extends RuntimeException{

  public PatientNotFoundException(String message){
    super(message);
  }

}
