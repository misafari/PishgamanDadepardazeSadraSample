package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.entity.Candidate;
import ir.safari.show.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@TransactionalService
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository repository;

    public void save(Candidate candidate) {
        repository.save(candidate);
    }

    public List<Candidate> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
