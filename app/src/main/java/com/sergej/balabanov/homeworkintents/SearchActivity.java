package com.sergej.balabanov.homeworkintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity {

    private Button mToCatalogActivityButton;
    private TextView mSearchTextView;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;
    private static final String SAVED_STRING_NAME = "STRING_NAME";
    private static final String SAVED_STRING_SURNAME = "STRING_SURNAME";
    private static final String SAVED_PARCEL = "PARCEL";
    private Data mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mData = new Data();
        Intent intent = getIntent();
        mTestModel = intent.getParcelableExtra("test_model");
        if (mTestModel == null) {
            mTestModel = new TestModel(mData.getName(), mData.getSurname(), mData.getIntegerList1(), mData.getIntegerList2());
            mName = mTestModel.getName();
            mSurname = mTestModel.getSurname();
        } else {
            mName = mTestModel.getName();
            mSurname = mTestModel.getSurname();
        }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(SAVED_STRING_NAME, mName);
        outState.putString(SAVED_STRING_SURNAME, mSurname);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mName = savedInstanceState.getString(SAVED_STRING_NAME);
        mSurname = savedInstanceState.getString(SAVED_STRING_SURNAME);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        mSearchTextView.setText(mName + " " + mSurname);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
