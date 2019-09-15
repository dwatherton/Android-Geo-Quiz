package com.bignerdranch.android.geoquiz.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.databinding.ActivityQuizBinding;
import com.bignerdranch.android.geoquiz.model.Quiz;

public class QuizViewModel implements IQuizViewModel {

    private Quiz model;
    private Context context;
    private ActivityQuizBinding binding;

    public final ObservableInt question = new ObservableInt();
    public final ObservableField<String> result = new ObservableField<>();

    public QuizViewModel(Context context, ActivityQuizBinding binding)
    {
        this.model = new Quiz();
        this.context = context;
        this.binding = binding;

        question.set(model.getCurrentQuestion().getTextResId());
    }

    @Override
    public void onTrueBtnClicked() {
        checkAnswer(model.getCurrentQuestion().isAnswerTrue());
    }

    @Override
    public void onFalseBtnClicked() {
        checkAnswer(!model.getCurrentQuestion().isAnswerTrue());
    }

    @Override
    public void onNextBtnClicked() {
        model.nextQuestion();
        question.set(model.getCurrentQuestion().getTextResId());

        result.set("");
        binding.trueButton.setEnabled(true);
        binding.falseButton.setEnabled(true);
        binding.nextButton.setEnabled(false);
    }

    private void checkAnswer(boolean userAnsweredCorrectly) {
        if (userAnsweredCorrectly) {
            result.set(context.getResources().getString(R.string.correct_toast));
            binding.resultTextView.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            result.set(context.getResources().getString(R.string.incorrect_toast));
            binding.resultTextView.setTextColor(context.getResources().getColor(R.color.red));
        }

        binding.trueButton.setEnabled(false);
        binding.falseButton.setEnabled(false);
        binding.nextButton.setEnabled(true);
    }
}
