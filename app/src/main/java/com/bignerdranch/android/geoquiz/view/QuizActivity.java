package com.bignerdranch.android.geoquiz.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bignerdranch.android.geoquiz.R;
import com.bignerdranch.android.geoquiz.databinding.ActivityQuizBinding;
import com.bignerdranch.android.geoquiz.viewmodel.QuizViewModel;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityQuizBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz);
        binding.setViewmodel(new QuizViewModel(this.getApplicationContext(), binding));
    }
}
