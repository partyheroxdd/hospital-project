# Miras and Azhar project for Spring course
# Hospital System



### General

This application was created for the hospital management system. In this case, give the opportunity to:
- control staff and patients 
- control their appointments for treatment
- give wide access to types of treatment for the patient
- make control of recording the date and time of the appointment and treatment status

### Modules

In this case, the project will be divided into the following modules
- Administration: 
  the administrator role will allow you to keep records of doctors and patients, 
  he can carry out all the operations and also give different access to resources
- Treatment:
  here you can see a list of all past, current and future treatments, change their status.
- Doctor:
  doctors can view the list of appointments from the patient and decide whether to accept it or not and update status
- Patient:
  the patient can freely register in the system and leave requests for treatment to a certain doctor of his specialization, and decide at what time it will be convenient   for him

### Roles

- ROLE_PATIENT: crud operations with his appointment
- ROLE_DOCTOR: crud operations with treatments, appointments
- ROLE_ADMIN: crud operations with all personal: doctor and patients, and can get access to all treatments and appointments 


