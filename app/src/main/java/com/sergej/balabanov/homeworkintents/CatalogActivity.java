package com.sergej.balabanov.homeworkintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CatalogActivity extends AppCompatActivity {

    private TextView mCatalogTextView;
    private Button mToMapActivityButton;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;

    private static final String SAVED_STRING_NAME = "STRING_NAME";
    private static final String SAVED_STRING_SURNAME = "STRING_SURNAME";
    private static final String SAVED_PARCEL = "PARCEL";

    private List<Integer> mIntegerList1;
    private List<Integer> mIntegerList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mName = "Sergei";
        mSurname = "Balabanov";
        mIntegerList1 = new ArrayList<>(2);
        mIntegerList2 = new ArrayList<>(3);
        mCatalogTextView = findViewById(R.id.catalog_text_view);
        mToMapActivityButton = findViewById(R.id.to_map_activity_button);
        mTestModel = new TestModel(mName, mSurname, mIntegerList1, mIntegerList2);
        mCatalogTextView.setText(mName + " " + mSurname);
        mToMapActivityButton.setText(R.string.to_map_activity);
        mToMapActivityButton.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, MapActivity.class);
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
        super.onRestoreInstanceState(savedInstanceState);
        mName = savedInstanceState.getString(SAVED_STRING_NAME);
        mSurname = savedInstanceState.getString(SAVED_STRING_SURNAME);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
    }
}
