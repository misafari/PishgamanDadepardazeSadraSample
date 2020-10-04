package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.Candidate;
import ir.safari.show.entity.Performance;
import ir.safari.show.entity.Score;
import ir.safari.show.entity.dto.PerformanceRequest;
import ir.safari.show.entity.dto.ScoreRequest;
import ir.safari.show.repository.PerformanceRepository;
import ir.safari.show.utils.CollectionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@TransactionalService
@RequiredArgsConstructor
public class PerformanceService {
private final UserService userService;
    private final PerformanceRepository repository;
    private final CandidateService candidateService;

    @Transactional
    public void save(PerformanceRequest performanceRequest) throws EntityNotFoundException {
        Performance performance = new Performance(performanceRequest);
        Candidate candidate = candidateService.findById(performanceRequest.getCandidateId());

        performance.setCandidate(candidate);

        performance.setAverageScore(
                performanceRequest.getScores().stream().mapToInt(ScoreRequest::getScore).average().getAsDouble()
        );

        for (ScoreRequest scoreRequest : performanceRequest.getScores()) {
            Score score = new Score();
            score.setScore(scoreRequest.getScore());
            score.setMentor(userService.findById(scoreRequest.getMentorId()));
            if (CollectionUtils.isNullOrEmpty(performance.getScores())) performance.setScores(new ArrayList<>());

            performance.getScores().add(score);
        }

        repository.save(performance);
    }

    public Performance findById(Long performanceId) throws EntityNotFoundException {
        return repository.findById(performanceId)
                .orElseThrow(() -> new EntityNotFoundException("Performance not found"));
    }
}
