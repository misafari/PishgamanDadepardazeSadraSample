package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.config.exception.EntityNotFoundException;
import ir.safari.show.entity.Performance;
import ir.safari.show.entity.dto.PerformanceRequest;
import ir.safari.show.entity.dto.PerformanceResponse;
import ir.safari.show.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CustomRestController(value = PerformanceController.ROOT_PATH)
public class PerformanceController {
    public static final String ROOT_PATH = "performance";
    private final PerformanceService service;

    @PostMapping
    public void save(@Valid @RequestBody PerformanceRequest performanceRequest) throws EntityNotFoundException {
        service.save(performanceRequest);
    }

    @GetMapping("forMentor")
    public List<PerformanceResponse> getForMentor() {
        return service.findByMentor();
    }

    @GetMapping("forAdmin")
    public List<PerformanceResponse> getForAdmin() {
        return service.findByAdmin();
    }

    @GetMapping("byCandidate/{candidateId}")
    public List<PerformanceResponse> getByCandidate(@PathVariable Long candidateId) {
        return service.findByCandidate(candidateId);
    }

}
