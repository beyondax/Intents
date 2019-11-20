package com.sergej.balabanov.homeworkintents;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TestModel implements Parcelable {

    private String mName;
    private String mSurname;

    private List<Integer> mDataList1;
    private List<Integer> mDataList2;

    public TestModel(String name, String surname, List<Integer> dataList1, List<Integer> dataList2) {
        mName = name;
        mSurname = surname;
        mDataList1 = dataList1;
        mDataList2 = dataList2;
    }

    protected TestModel(Parcel in) {
        mName = in.readString();
        mSurname = in.readString();
        in.readList(mDataList1, TestModel.class.getClassLoader());
        in.readList(mDataList2, TestModel.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }


    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mSurname);
        dest.writeList(mDataList1);
        dest.writeList(mDataList2);
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public List<Integer> getDataList1() {
        return mDataList1;
    }

    public List<Integer> getDataList2() {
        return mDataList2;
    }
}
