package kz.iitu.itis1908.hospitalmanagementservice.service;

import java.util.List;
import kz.iitu.itis1908.hospitalmanagementservice.model.dto.DoctorDTO;

public interface DoctorService {

  DoctorDTO getDoctor(String doctorId);

  DoctorDTO updateDoctor(DoctorDTO doctorDTO);

  DoctorDTO createDoctor(DoctorDTO doctorDTO);

  void deleteDoctor(String doctorId);

  List<DoctorDTO> getAllDoctors();

}
