package co.test.testpro.repository;

import co.test.testpro.domain.authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<authority, String> {
}
