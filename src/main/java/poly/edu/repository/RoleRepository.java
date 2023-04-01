package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.domain.Role;

public interface RoleRepository extends JpaRepository<Role,String> {

}
