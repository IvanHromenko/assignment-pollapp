package com.pollapp.assignment.service;

import com.pollapp.assignment.model.AnswerOption;
import com.pollapp.assignment.repository.AnswerOptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerOptionService {

    private final AnswerOptionRepository answerOptionRepository;

    public AnswerOptionService(AnswerOptionRepository answerOptionRepository) {
        this.answerOptionRepository = answerOptionRepository;
    }

    public List<AnswerOption> getAllAnswerOptions() {
        return answerOptionRepository.findAll();
    }

    public AnswerOption getAnswerOptionById(int id) {
        return answerOptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found"));
    }

    public void incrementSelectionCount(int id) {
        AnswerOption answerOption = getAnswerOptionById(id);
        answerOption.setNumberOfSelections(answerOption.getNumberOfSelections() + 1);
        answerOptionRepository.save(answerOption);
    }
}
