package ir.safari.show.service;

import ir.safari.show.config.annotation.TransactionalService;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.config.exception.UniqueException;
import ir.safari.show.entity.Candidate;
import ir.safari.show.entity.dto.CandidateRequest;
import ir.safari.show.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@TransactionalService
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository repository;

    @Transactional
    public void save(CandidateRequest candidateRequest) throws UniqueException {
        if (repository.existsByNationalCode(candidateRequest.getNationalCode()))
            throw new UniqueException("Candidate with this national code is exist.");
        repository.save(candidateRequest.map());
    }

    @Transactional
    public void save(Candidate candidate) {
        repository.save(candidate);
    }

    public Candidate findById(Long id) throws EntityNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate Not Found."));
    }

    public boolean existByNationalCode(String nationalCode) {
        return repository.existsByNationalCode(nationalCode);
    }

    public List<Candidate> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }
}
