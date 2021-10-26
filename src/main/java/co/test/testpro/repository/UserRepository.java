package co.test.testpro.repository;

import co.test.testpro.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities") //쿼리가 수행 될때 Lazywhghlrk 아니고 Eager 조회로 authorites 정보를 가져오게 됩니다.
    Optional<User> findOneWithAuthoritiesByUsername(String username); //username을 기준으로 User정보를 가져올때 권한 정보도 같이 가져오게 합니다.
}
