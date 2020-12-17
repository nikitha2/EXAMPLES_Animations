package com.example.examples_animations;

import java.io.Serializable;

public class Grid_Item implements Serializable {
    private static final String LARGE_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
    private static final String THUMB_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";

    private final String mName;
    private final String mAuthor;
    private final String mFileName;

    Grid_Item (String name, String author, String fileName) {
        mName = name;
        mAuthor = author;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() + mFileName.hashCode();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }

    public String getPhotoUrl() {
        return LARGE_BASE_URL + mFileName;
    }

    public String getThumbnailUrl() {
        return THUMB_BASE_URL + mFileName;
    }
}
