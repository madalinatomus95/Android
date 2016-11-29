package com.example.mada.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mada on 11/26/2016.
 */

public class BookListAdapter extends BaseAdapter
{
    BooksList booksList = BooksList.getInstance();
    private Context context;

    public BookListAdapter(Context context)
    {
        this.context = context;
    }

    public BooksList getBooksList()
    {
        return booksList;
    }
    @Override
    public int getCount()
    {
        return booksList.getBooks().size();
    }

    @Override
    public Book getItem(int position) {
        return booksList.getBooks().get(position);
    }

    @Override
    public long getItemId(int position) {
        return booksList.getBooks().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get a reference to the LayoutInflater service
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // check if we can reuse a previously defined cell which now is not visible anymore
        View myRow = (convertView == null) ?
                inflater.inflate(R.layout.books_list_item, parent, false) : convertView;
        /* get the visual elements and update them with the information from the model */
        Book book = booksList.getBooks().get(position);
        TextView title = (TextView) myRow.findViewById(R.id.title);
        title.setText(book.getTitle());
        TextView author = (TextView) myRow.findViewById(R.id.author);
        author.setText(book.getAuthor());
        TextView content = (TextView) myRow.findViewById(R.id.content);
        content.setText(book.getContent());
        ImageView imageView = (ImageView) myRow.findViewById(R.id.image);
        Context context = imageView.getContext();
        int imgResId = content.getResources().getIdentifier(book.getImage(),"drawable",context.getPackageName());
        imageView.setImageResource(imgResId);
        return myRow;

    }
}
