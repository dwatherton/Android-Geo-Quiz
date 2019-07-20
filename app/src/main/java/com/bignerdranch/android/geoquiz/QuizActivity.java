package com.bignerdranch.android.geoquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bignerdranch.android.geoquiz.model.Quiz;

public class QuizActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mResultTextView;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mQuestionTextView = findViewById(R.id.question_text_view);
        mResultTextView = findViewById(R.id.result_text_view);

        mTrueButton = findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextQuestion();
            }
        });

        quiz = new Quiz();
        updateQuestionView();
        reset();
    }

    private void goToNextQuestion() {
        quiz.nextQuestion();
        updateQuestionView();
        reset();
    }

    private void checkAnswer(boolean userPressedTrue) {
        int answerColor;
        boolean answerIsTrue = quiz.getCurrentQuestion().isAnswerTrue();
        int messageResId;

        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
            answerColor = getResources().getColor(R.color.green);
        } else {
            messageResId = R.string.incorrect_toast;
            answerColor = getResources().getColor(R.color.red);
        }

        mResultTextView.setText(messageResId);
        mResultTextView.setTextColor(answerColor);
        onQuestionAnswered();
    }

    private void updateQuestionView() {
        mQuestionTextView.setText(quiz.getCurrentQuestion().getTextResId());
    }

    private void reset() {
        mResultTextView.setText("");
        mTrueButton.setEnabled(true);
        mFalseButton.setEnabled(true);
        mNextButton.setEnabled(false);
    }

    private void onQuestionAnswered() {
        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
        mNextButton.setEnabled(true);
    }

}
