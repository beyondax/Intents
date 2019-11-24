package com.sergej.balabanov.homeworkintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CatalogActivity extends AppCompatActivity {

    private TextView mCatalogTextView;
    private Button mToMapActivityButton;
    private String mName;
    private String mSurname;
    private TestModel mTestModel;
    private Data mData;

    private static final String SAVED_STRING_NAME = "STRING_NAME";
    private static final String SAVED_STRING_SURNAME = "STRING_SURNAME";
    private static final String SAVED_PARCEL = "PARCEL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        mData = new Data();
        mTestModel = new TestModel(mData.getName(), mData.getSurname(), mData.getIntegerList1(), mData.getIntegerList2());
        mName = mTestModel.getName();
        mSurname = mTestModel.getSurname();

        mCatalogTextView = findViewById(R.id.catalog_text_view);
        mToMapActivityButton = findViewById(R.id.to_map_activity_button);
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
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_STRING_NAME, mName);
        outState.putString(SAVED_STRING_SURNAME, mSurname);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mName = savedInstanceState.getString(SAVED_STRING_NAME);
        mSurname = savedInstanceState.getString(SAVED_STRING_SURNAME);
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        mCatalogTextView.setText(mName + " " + mSurname);
        super.onRestoreInstanceState(savedInstanceState);
    }
}
