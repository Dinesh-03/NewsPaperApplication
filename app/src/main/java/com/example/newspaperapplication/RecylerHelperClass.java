package com.example.newspaperapplication;



public class RecylerHelperClass implements News{
    private int imageView;
    private String textView;
    private String newsLink;

    public RecylerHelperClass(int imageView, String textView, String newsLink) {
        this.imageView = imageView;
        this.textView = textView;
        this.newsLink = newsLink;
    }



    public int getImageView() {
        return imageView;
    }

    public String getTextView() {
        return textView;
    }

    public String getNewsLink() {
        return newsLink;
    }

    @Override
    public int getType() {
        return News.TYPE_PAPER;
    }
}
