package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority,Integer> {
}
