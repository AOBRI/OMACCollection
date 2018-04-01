package com.aobri.omaccollection.model;

/**
 * Created by Ahmed on 022 22-03-2018.
 * class representing a Word containing all translations of a single word.
 */

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
//    private static final int NO_AUDIO_PROVIDED = -1;

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;


    public Word(String mDefaultTranslation, String mMiwokTranslation, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int mImageResourceId, int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = mImageResourceId;
        this.mAudioResourceId = mAudioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }


    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }


    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }


    public int getImageResourceId() {
        return mImageResourceId;
    }


    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

/*
    public void setDefaultTranslation(String mDefaultTranslation) {
        this.mDefaultTranslation = mDefaultTranslation;
    }
    public void setMiwokTranslation(String mMiwokTranslation) {
        this.mMiwokTranslation = mMiwokTranslation;
    }
    public void setImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }
    public void setAudioResourceId(int mAudioResourceId) {
        this.mAudioResourceId = mAudioResourceId;
    }
*/
}
