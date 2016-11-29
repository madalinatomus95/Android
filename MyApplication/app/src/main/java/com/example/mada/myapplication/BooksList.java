package com.example.mada.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mada on 11/26/2016.
 */

public class BooksList
{
    private static BooksList instance;
    private List<Book> books;
    public static BooksList getInstance()
    {
        if (instance==null)
            return new BooksList();
        else
            return instance;
    }

    public BooksList()
    {
        init();
    }

    public void restart() {init();}

    public List<Book> getBooks()
    {
        return this.books;
    }

    public void init()
    {
        this.books = new ArrayList<Book>();
        this.books.add(new Book(1,"The Catcher in the Rye", "J.D. Salinger","Since his debut in 1951 as The Catcher in the Rye, Holden Caulfeld has been synonymous with 'cynical adolescent'", "book1"));
        this.books.add(new Book(2,"Amintiri din copilarie", "Ion Creanga","Cartea ofera o relatare detaliata a copilariei lui Ion Creanga, petrecuta in ceea ce era atunci Principatul Moldovei, cu amanunte privind peisajul social al universului copilariei sale", "book2"));
        this.books.add(new Book(3,"Exilul si imparatia", "Albert Camus","Un univers in care granita dintre fictiune si realitate nu e vizibila, ceea ce face cu atat mai atragatoare lectura", "book3"));
    }
}
