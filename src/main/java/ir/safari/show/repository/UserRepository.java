package ir.safari.show.repository;

import ir.safari.show.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(@Param("username") String username);

    Optional<User> findFirstByUsername(@Param("username") String username);
}
