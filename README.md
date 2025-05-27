# Clinic-Management-System
The Clinic Management System (CMS) is a comprehensive software solution designed to manage patient flow, appointments, billing, and auxiliary services in a clinic. The system supports online appointment booking, token generation for walk-in and scheduled patients, billing for consultations, lab tests, and pharmacy services, and generates various reports for operational efficiency.

## Key Modules
●	Reception Module: Manages patient registration, token generation, appointment scheduling, consultation billing, and daily collection reports (filterable by doctor and department).  
●	Doctor Module: Handles patient consultations, lab and pharmacy prescriptions, and patient history tracking.  
●	Lab Module: Manages lab test prescriptions, test execution, report generation, and status tracking.  
●	Pharmacy Module: Manages medicine prescriptions, stock inventory, billing, and generates cash collection and stock reports.  
●	Patient Portal: Enables patients to book appointments, view prescriptions, lab reports, and billing history.  

## Classes and Attributes
-	Patient
  
    -	Attributes: patient_id, name, contact, address, dob, gender  
    -	Methods: register(), updateDetails(), getHistory()
    
-	Doctor
  
    -	Attributes: doctor_id, name, specialization, department  
    -	Methods: conductConsultation(), prescribeLabTest(), prescribeMedicine(), viewPatientHistory()
    
-	Appointment
  
    -	Attributes: appointment_id, patient_id, doctor_id, date, time, status  
    -	Methods: book(), cancel(), reschedule()
    
-	Token
  
    -	Attributes: token_id, patient_id, doctor_id, queue_number, date  
    -	Methods: generate(), cancel()
    
-	Consultation
  
    -	Attributes: consultation_id, patient_id, doctor_id, date, diagnosis  
    -	Methods: record(), update()
    
-	LabPrescription
   
    -	Attributes: prescription_id, patient_id, doctor_id, test_type, status  
    -	Methods: create(), updateStatus(), getStatus()
    
-	LabReport
  
    -	Attributes: report_id, prescription_id, results, date  
    -	Methods: generate(), forward()

-	PharmacyPrescription
  
    -	Attributes: prescription_id, patient_id, doctor_id, medicines  
    -	Methods: create(), dispense()
    
-	Medicine
  
    -	Attributes: medicine_id, name, stock_quantity, price  
    -	Methods: updateStock(), getStock()
    
-	Bill
  
    -	Attributes: bill_id, patient_id, type (consultation/lab/pharmacy), amount, date  
    -	Methods: generate(), pay()
    
-	Report
  
    -	Attributes: report_id, type (collection/stock/lab), data, date
    -	Methods: generate(), filter()
    
