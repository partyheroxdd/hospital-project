package kz.iitu.itis1908.hospitalmanagementservice.repository;


import java.util.Optional;
import kz.iitu.itis1908.hospitalmanagementservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  User findUserById(Long id);

  boolean existsByUsername(String username);
}
