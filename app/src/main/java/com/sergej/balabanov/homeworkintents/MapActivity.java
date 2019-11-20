package com.sergej.balabanov.homeworkintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    private Button mToPersonalActivityButton;
    private TextView mMapTextView;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        mTestModel = intent.getParcelableExtra("test_model");
        mName = mTestModel.getName();
        mSurname = mTestModel.getSurname();

        mToPersonalActivityButton = findViewById(R.id.to_personal_activity_button);
        mMapTextView = findViewById(R.id.map_text_view);
        mMapTextView.setText(mName + " " + mSurname);
        mToPersonalActivityButton.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, PersonalActivity.class);
        intent.putExtra("test_model", mTestModel);
        startActivity(intent);
    }
}
