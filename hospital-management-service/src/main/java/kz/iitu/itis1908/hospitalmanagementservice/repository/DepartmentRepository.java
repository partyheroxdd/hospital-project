package kz.iitu.itis1908.hospitalmanagementservice.repository;

import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, Long> {
  Department findDepartmentByDepartmentId(Long departmentId);
}
