package com.bignerdranch.android.geoquiz.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.presenter.IQuizPresenter;
import com.bignerdranch.android.geoquiz.presenter.QuizPresenter;

public class QuizActivity extends AppCompatActivity implements IQuizView {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private TextView mResultTextView;
    private IQuizPresenter presenter;

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
                presenter.onTrueBtnClicked();
            }
        });

        mFalseButton = findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onFalseBtnClicked();
            }
        });

        mNextButton = findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextBtnClicked();
            }
        });

        presenter = new QuizPresenter(this);
    }

    @Override
    public void updateResult(boolean userAnsweredCorrectly) {
        int answerColor;
        int messageResId;

        if (userAnsweredCorrectly) {
            messageResId = R.string.correct_toast;
            answerColor = getResources().getColor(R.color.green);
        } else {
            messageResId = R.string.incorrect_toast;
            answerColor = getResources().getColor(R.color.red);
        }

        mResultTextView.setText(messageResId);
        mResultTextView.setTextColor(answerColor);

        mTrueButton.setEnabled(false);
        mFalseButton.setEnabled(false);
        mNextButton.setEnabled(true);
    }

    @Override
    public void updateQuestion(int questionTextResId) {
        mQuestionTextView.setText(questionTextResId);

        mResultTextView.setText("");
        mTrueButton.setEnabled(true);
        mFalseButton.setEnabled(true);
        mNextButton.setEnabled(false);
    }
}
