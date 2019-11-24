package com.sergej.balabanov.homeworkintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalActivity extends AppCompatActivity {

    private Button mToSearchActivityButton;
    private TextView mPersonalTextView;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Intent intent = getIntent();
        mTestModel = intent.getParcelableExtra("test_model");
        mName = mTestModel.getName();
        mSurname = mTestModel.getSurname();

        mToSearchActivityButton = findViewById(R.id.to_search_activity_button);
        mPersonalTextView = findViewById(R.id.personal_text_view);
        mPersonalTextView.setText(mName + " " + mSurname);
        mToSearchActivityButton.setText(R.string.to_search_activity);
        mToSearchActivityButton.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("test_model", mTestModel);
        startActivity(intent);
    }
}

