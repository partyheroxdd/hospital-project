package kz.iitu.itis1908.hospitalmanagementservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kz.iitu.itis1908.hospitalmanagementservice.exceptions.NotFoundException;
import kz.iitu.itis1908.hospitalmanagementservice.model.Constants.ApiMessages;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DoctorDTO;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Doctor;
import kz.iitu.itis1908.hospitalmanagementservice.repository.DoctorRepository;
import kz.iitu.itis1908.hospitalmanagementservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepository doctorRepository;

  @Override
  public DoctorDTO getDoctor(String doctorId) {
    Doctor doctor = findDoctorById(doctorId);
    log.info("Get doctor with id - {}", doctorId);
    return DoctorDTO.builder()
        .doctorId(doctor.getDoctorId())
        .departmentId(doctor.getDepartmentId())
        .city(doctor.getCity())
        .fullName(doctor.getFullName())
        .specialization(doctor.getSpecialization())
        .position(doctor.getPosition())
        .build();
  }

  @Override
  public DoctorDTO updateDoctor(DoctorDTO doctorDTO) {
    Doctor doctor = findDoctorById(doctorDTO.getDoctorId());
    doctor.setDepartmentId(doctorDTO.getDepartmentId());
    doctor.setCity(doctorDTO.getCity());
    doctor.setSpecialization(doctorDTO.getSpecialization());
    doctor.setPosition(doctorDTO.getPosition());
    doctorRepository.save(doctor);
    log.info("Update Doctor with id - {}", doctorDTO.getDoctorId());
    return doctorDTO;
  }

  @Override
  public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
    Doctor doctor = Doctor.builder()
        .doctorId(doctorDTO.getDoctorId())
        .departmentId(doctorDTO.getDepartmentId())
        .city(doctorDTO.getCity())
        .fullName(doctorDTO.getFullName())
        .specialization(doctorDTO.getSpecialization())
        .position(doctorDTO.getPosition())
        .build();
    doctorRepository.save(doctor);
    log.info("Doctor successfully created - {}", doctor.getDoctorId());
    return doctorDTO;
  }

  @Override
  public void deleteDoctor(String doctorId) {
    Doctor doctor = findDoctorById(doctorId);
    doctorRepository.delete(doctor);
    log.info("Delete doctor with id - {}", doctorId);
  }

  @Override
  public List<DoctorDTO> getAllDoctors() {
    List<Doctor> doctors = doctorRepository.findAll();
    List<DoctorDTO> doctorDTOList = new ArrayList<>();
    doctors.forEach(doctor -> doctorDTOList.add(DoctorDTO.builder()
        .doctorId(doctor.getDoctorId())
        .departmentId(doctor.getDepartmentId())
        .city(doctor.getCity())
        .fullName(doctor.getFullName())
        .specialization(doctor.getSpecialization())
        .position(doctor.getPosition())
        .build()));
    return doctorDTOList;
  }

  public Doctor findDoctorById(String doctorId) {
    Doctor doctor = doctorRepository.findDoctorByDoctorId(doctorId);
    if (Objects.isNull(doctor)) {
      throw new NotFoundException(ApiMessages.DOCTOR_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
    return doctor;
  }

}
