package com.sergej.balabanov.homeworkintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private Button mToCatalogActivityButton;
    private TextView mSearchTextView;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        mTestModel = intent.getParcelableExtra("test_model");
        mName = mTestModel.getName();
        mSurname = mTestModel.getSurname();

        mToCatalogActivityButton = findViewById(R.id.to_catalog_activity_button);
        mSearchTextView = findViewById(R.id.search_text_view);
        mSearchTextView.setText(mName + " " + mSurname);
        mToCatalogActivityButton.setText(R.string.to_catalog_activity);
        mToCatalogActivityButton.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, CatalogActivity.class);
        intent.putExtra("test_model", mTestModel);
        startActivity(intent);
    }
}
