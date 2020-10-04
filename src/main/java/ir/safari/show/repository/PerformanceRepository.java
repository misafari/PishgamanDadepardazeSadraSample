package ir.safari.show.repository;

import ir.safari.show.entity.Performance;
import ir.safari.show.entity.dto.PerformanceResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
    @Query(value = "SELECT new ir.safari.show.entity.dto.PerformanceResponse(p.averageScore, p.songName, p.candidate.id)" +
            " FROM User as u join Team as t on u.id = t.mentor.id join" +
            " Candidate as c on t.id = c.team.id join Performance as p " +
            "on c.id = p.candidate.id where u.username = :mentorUsername")
    List<PerformanceResponse> getAllByMentorUsername(@Param("mentorUsername") String mentorUsername);

    @Query(value = "SELECT new ir.safari.show.entity.dto.PerformanceResponse(p.averageScore, p.songName, p.candidate.id)" +
            " FROM Team as t join Candidate as c on t.id = c.team.id join Performance as p " +
            "on c.id = p.candidate.id")
    List<PerformanceResponse> getAllForAdmin();

    @Query(value = "SELECT new ir.safari.show.entity.dto.PerformanceResponse(p.averageScore, p.songName, p.candidate.id)" +
            " FROM Performance as p where p.candidate.id = :candidateId")
    List<PerformanceResponse> getAllByCandidate_Id(@Param("candidateId") Long candidateId);
}
