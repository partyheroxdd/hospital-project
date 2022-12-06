package kz.iitu.itis1908.hospitalmanagementservice.repository;

import kz.iitu.itis1908.hospitalmanagementservice.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String name);
}
