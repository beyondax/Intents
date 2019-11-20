package com.sergej.balabanov.homeworkintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PersonalActivity extends AppCompatActivity {

    private Button mToSearchActivityButton;
    private TextView mPersonalTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
    }
}
