package kz.iitu.itis1908.hospitalmanagementservice.model.Constants;

public class ApiMessages {

  public static final String BAD_CREDENTIALS = "Invalid Username or Password";
  public static final String USER_ALREADY_EXISTS = "User already exists with username";
  public static final String INVALID_TOKEN = "Expired or Invalid Token";
  public static final String INVALID_USERNAME = "Username must be +7 phone format";
  public static final String INVALID_ROLE_NAME = "User's role must be start with [ROLE_]";
  public static final String PATIENT_NOT_FOUND = "Patient with such id not found";
  public static final String DOCTOR_NOT_FOUND = "Doctor with such id not found";
  public static final String APPOINTMENT_NOT_FOUND = "Appointment with such id not found";
  public static final String APPOINTMENT_ALREADY_EXISTS = "Doctor doesn't have free appointment at this time";
  public static final String DEPARTMENT_NOT_FOUND = "Department with such id not found";
}
