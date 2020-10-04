package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.Performance;
import ir.safari.show.entity.Score;
import ir.safari.show.entity.dto.ScoreRequest;
import ir.safari.show.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;

@TransactionalService
@RequiredArgsConstructor
public class ScoreService {
private final PerformanceService performanceService;
    private final ScoreRepository repository;

    public void save(ScoreRequest scoreRequest) throws EntityNotFoundException {
        Performance performance = performanceService.findById(scoreRequest.getPerformanceId());

        repository.save(new Score());
    }
}
