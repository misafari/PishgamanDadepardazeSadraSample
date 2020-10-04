package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;

@TransactionalService
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository repository;
}
