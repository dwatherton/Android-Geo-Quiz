package com.bignerdranch.android.geoquiz.model;

import com.bignerdranch.android.geoquiz.R;

/**
 * Created by irconde on 2019-07-20.
 */
public class Quiz {

    private Question questions[];
    private int currentQuestion;

    public Quiz() {
        currentQuestion = 0;
        questions = new Question[] {
                new Question(R.string.question_australia, true),
                new Question(R.string.question_oceans, true),
                new Question(R.string.question_mideast, false),
                new Question(R.string.question_africa, false),
                new Question(R.string.question_americas, true),
                new Question(R.string.question_asia, true),
        };
    }

    public void nextQuestion() {
        if (currentQuestion < questions.length - 1) {
            currentQuestion++;
        }
    }

    public Question getCurrentQuestion() {
        return questions[currentQuestion];
    }

}
