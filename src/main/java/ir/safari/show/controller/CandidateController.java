package ir.safari.show.controller;

import ir.safari.show.config.annotation.CustomRestController;
import ir.safari.show.entity.Candidate;
import ir.safari.show.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@CustomRestController(value = CandidateController.ROOT_PATH)
public class CandidateController {
    public static final String ROOT_PATH = "candidate";
    private final CandidateService service;

    @PostMapping
    public void save(@RequestBody Candidate candidate) {
        service.save(candidate);
    }
}
