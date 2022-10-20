package kz.iitu.itis1908.hospitalmanagementservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor()
@Entity
@Builder
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username", unique = true, nullable = false)
  private String username;

  @Column(name = "password")
  private String password;


  @ManyToMany
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"
      ),
      inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"
      )
  )
  @JsonIgnore
  private Set<Role> roles = new HashSet<>();

}
