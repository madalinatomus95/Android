package com.example.mada.myapplication;

/**
 * Created by Mada on 11/26/2016.
 */

public class Book
{
    private int id;
    private String author;
    private String title;
    private String content;
    private String image;
    private boolean favorite;
    public Book(int id, String title,String author,String content, String image)
    {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public void setFavorite(boolean favorite) {this.favorite= favorite;}
    public void setId(int id)
    {
        this.id = id;
    }

    public void setAuthor(String author)
    {
        this.author =author;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public int getId()
    {
        return this.id;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getContent()
    {
        return this.content;
    }

    public String getImage()
    {
        return this.image;
    }

    public boolean getFavorite() {return this.favorite;}
}
