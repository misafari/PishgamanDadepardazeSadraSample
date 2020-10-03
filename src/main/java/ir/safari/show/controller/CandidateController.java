package ir.safari.show.controller;

import ir.safari.show.entity.Candidate;
import ir.safari.show.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

@RequestMapping(value = CandidateController.ROOT_PATH)
public class CandidateController {
    public static final String ROOT_PATH = "candidate";
    private final CandidateService service;

    @PostMapping
    public void save(@RequestBody Candidate candidate) {
        service.save(candidate);
    }
}
