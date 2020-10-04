package ir.safari.show.repository;

import ir.safari.show.entity.Team;
import ir.safari.show.entity.dto.TeamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select p.averageScore from Team as t join Candidate as c on t.id = c.team.id join Performance as p" +
            " on c.id = p.candidate.id where t.id = :teamId")
    List<Double> getTeamScore(@Param("teamId") Long teamId);

    @Query("select new ir.safari.show.entity.dto.TeamResponse(t.name, t.createDate)" +
            " from Team as t where t.mentor.username = :mentor")
    List<TeamResponse> findAllByMentor(@Param("mentor") String mentor);

    @Query("select new ir.safari.show.entity.dto.TeamResponse(t.name, t.createDate)" +
            " from Team as t")
    List<TeamResponse> findAllByAdmin();
}
