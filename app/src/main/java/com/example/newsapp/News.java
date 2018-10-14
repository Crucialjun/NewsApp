package com.example.newsapp;

import java.util.Date;

public class News {
    private String mNewsTitle;
    private String mStoryUrl;
    private String mNewsContent;
    private String mAuthor;
    private String mPublishTime;

    public News(String newsTitle,String storyUrl,String newsContent,String author
            , String publishTime){
        mNewsTitle = newsTitle;
        mStoryUrl =storyUrl;
        mNewsContent = newsContent;
        mAuthor = author;
        mPublishTime = publishTime;

    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getStoryUrl() {
        return mStoryUrl;
    }


    public String getNewsContent() {
        return mNewsContent;
    }

    public String getAuthor(){
        return mAuthor;
    }

    public String getPublishTime(){
        return mPublishTime;
    }
}
