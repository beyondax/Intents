package com.sergej.balabanov.homeworkintents;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private final String mLetters = "abcdefghijklmopqrstuvwxyz";
    private final String mName;
    private final String mSurname;
    private final List<Integer> mIntegerList1;
    private final List<Integer> mIntegerList2;

    public Data() {
        this.mName = randomAlphaNumeric(5);
        this.mSurname = randomAlphaNumeric(10);
        mIntegerList1 = new ArrayList<>((int) Math.round(Math.random() * 100));
        mIntegerList2 = new ArrayList<>((int) Math.round(Math.random() * 100));
    }

    public String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * mLetters.length());
            builder.append(mLetters.charAt(character));
        }
        return builder.toString();
    }

    public String getName() {
        return mName;
    }

    public String getSurname() {
        return mSurname;
    }

    public List<Integer> getIntegerList1() {
        return mIntegerList1;
    }

    public List<Integer> getIntegerList2() {
        return mIntegerList2;
    }
}
