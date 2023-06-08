package com.pollapp.assignment.controller;

import com.pollapp.assignment.model.AnswerOption;
import com.pollapp.assignment.service.AnswerOptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer-options")
public class AnswerOptionController {

    private final AnswerOptionService answerOptionService;

    public AnswerOptionController(AnswerOptionService answerOptionService) {
        this.answerOptionService = answerOptionService;
    }

    @GetMapping
    public List<AnswerOption> getAllAnswerOptions() {
        return answerOptionService.getAllAnswerOptions();
    }

    @GetMapping("/{id}")
    public AnswerOption getAnswerOptionById(@PathVariable int id) {
        return answerOptionService.getAnswerOptionById(id);
    }

    @PostMapping("/{id}/increment")
    public void incrementSelectionCount(@PathVariable int id) {
        answerOptionService.incrementSelectionCount(id);
    }
}
