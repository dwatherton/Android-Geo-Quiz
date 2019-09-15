package com.bignerdranch.android.geoquiz.presenter;

import com.bignerdranch.android.geoquiz.model.Quiz;
import com.bignerdranch.android.geoquiz.view.IQuizView;

public class QuizPresenter implements IQuizPresenter {

    private Quiz model;
    private IQuizView view;

    public QuizPresenter(IQuizView view)
    {
        this.model = new Quiz();
        this.view = view;

        view.updateQuestion(model.getCurrentQuestion().getTextResId());
    }

    @Override
    public void onTrueBtnClicked() {
        view.updateResult(model.getCurrentQuestion().isAnswerTrue());
    }

    @Override
    public void onFalseBtnClicked() {
        view.updateResult(!model.getCurrentQuestion().isAnswerTrue());
    }

    @Override
    public void onNextBtnClicked() {
        model.nextQuestion();
        view.updateQuestion(model.getCurrentQuestion().getTextResId());
    }
}
