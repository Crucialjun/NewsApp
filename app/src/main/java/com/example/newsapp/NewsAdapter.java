package com.example.newsapp;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


        String content = currentNewsItem.getNewsContent();

        String fromattedContent = stripHtml(content);
        TextView newsContent = listItemView.findViewById(R.id.newsArticle);
        newsContent.setText(fromattedContent);

        String authorName = currentNewsItem.getAuthor();
        TextView author = listItemView.findViewById(R.id.author_name);
        author.setText("Source : " + authorName);



       String timeOfPublish = currentNewsItem.getPublishTime();

       SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(timeOfPublish);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = formatDate(date);
       TextView publishTime = listItemView.findViewById(R.id.publishtime);
        publishTime.setText(formattedDate);


        return listItemView;



    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        return dateFormat.format(dateObject);
    }

    public String stripHtml(String html)
    {
        return Html.fromHtml(html).toString();
    }


}
