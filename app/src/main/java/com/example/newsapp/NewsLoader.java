package com.example.newsapp;

import android.content.Context;

import android.content.AsyncTaskLoader;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Instantiates a new News loader.
     *
     * @param context the context
     * @param url     the url
     */
    public NewsLoader(Context context,String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if(mUrl == null){
            return null;
        }

        // Perform the network request, parse the response, and extract the news
        List<News> newsItems = QueryUtils.fetchNewsData(mUrl);
        return  newsItems;
    }
}
