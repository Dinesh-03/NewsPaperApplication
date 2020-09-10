package com.example.newspaperapplication;

public class NewsPaperDeatis implements News{
    public int textDetails;
    public String newsLink;

    public String getNewsLink() {
        return newsLink;
    }

    public NewsPaperDeatis(int textDetails, String newsLink) {
        this.textDetails = textDetails;
        this.newsLink=newsLink;
    }

    @Override
    public int getType() {
        return News.TYPE_DETAILS;
    }
}
