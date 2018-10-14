package com.example.newsapp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * The type News adapter.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Instantiates a new News adapter.
     *
     * @param context the context
     * @param news    the news
     */
    public NewsAdapter(Context context, List<News> news){
        super(context,0,news);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView ==null){
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.news_layout_activity,parent,false);
        }

        News currentNewsItem = getItem(position);

        String newsTitle = currentNewsItem.getNewsTitle();
        TextView title = listItemView.findViewById(R.id.newsTittle);
        title.setText(newsTitle);

        String imageUrl = currentNewsItem.getUrlToImage();
        ImageView newsImage = listItemView.findViewById(R.id.thumbnail);
       newsImage.setImageURI(Uri.parse(imageUrl));

        String content = currentNewsItem.getNewsContent();
        TextView newsContent = listItemView.findViewById(R.id.newsArticle);
        newsContent.setText(content);

        String authorName = currentNewsItem.getAuthor();
        TextView author = listItemView.findViewById(R.id.author_name);
        author.setText(authorName);

        String timeOfPublish = currentNewsItem.getPublishTime();
        TextView publishTime = listItemView.findViewById(R.id.publishtime);
        publishTime.setText(timeOfPublish);


        return listItemView;



    }
}
