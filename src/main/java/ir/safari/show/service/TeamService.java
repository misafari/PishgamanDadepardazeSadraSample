package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.Candidate;
import ir.safari.show.entity.Team;
import ir.safari.show.entity.User;
import ir.safari.show.entity.dto.TeamRequest;
import ir.safari.show.repository.TeamRepository;
import ir.safari.show.utils.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@TransactionalService
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository repository;
    private final CandidateService candidateService;
    private final UserService userService;

    @Transactional
    public void save(TeamRequest teamRequest) throws EntityNotFoundException {
        List<Candidate> candidates = candidateService.findAllByIds(teamRequest.getCandidates());
        User mentor = userService.findById(teamRequest.getMentor());

        if (CollectionUtils.isNullOrEmpty(candidates))
            throw new EntityNotFoundException("candidate not found");

        Team team = new Team(teamRequest.getName(), candidates, mentor);
        System.out.println(team);
        repository.save(team);
    }
}
