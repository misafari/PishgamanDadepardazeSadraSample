package ir.safari.show.repository;

import ir.safari.show.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsByNationalCode(@Param("nationalCode") String nationalCode);
}
