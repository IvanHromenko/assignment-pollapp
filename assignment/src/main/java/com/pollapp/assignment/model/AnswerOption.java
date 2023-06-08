package com.pollapp.assignment.model;


import jakarta.persistence.*;

@Entity
@Table(name = "answer_options")
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "answer_option")
    private String answerOption;
    @Column(name = "number_of_selections")
    private int numberOfSelections;

    public AnswerOption() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public int getNumberOfSelections() {
        return numberOfSelections;
    }

    public void setNumberOfSelections(int numberOfSelections) {
        this.numberOfSelections = numberOfSelections;
    }
}
