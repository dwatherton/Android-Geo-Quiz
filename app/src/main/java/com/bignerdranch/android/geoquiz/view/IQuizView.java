package com.bignerdranch.android.geoquiz.view;

public interface IQuizView {
    void updateResult(boolean userAnsweredCorrectly);
    void updateQuestion(int questionTextResId);
}
