package com.example.mada.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private BookListAdapter bookListAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bookListAdapter = new BookListAdapter(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(bookListAdapter);
        listView.setOnItemClickListener(this);
        bookListAdapter.notifyDataSetChanged();
        registerForContextMenu(listView);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // verificăm dacă meniul este creat pentru lista vizată
        if (v.getId() == R.id.listView) {
            ListView listView = (ListView) v;
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Book book = (Book) listView.getItemAtPosition(info.position);
            // identificăm elementul selectat din listă
            if (book != null)
                menu.setHeaderTitle(book.getTitle());
            else
                menu.setHeaderTitle("null");
            // încărcăm structura vizuală a meniului
            getMenuInflater().inflate(R.menu.operations_menu, menu);
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        // accesarea informației atașate meniului contextual
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        // identificarea elementului selectat din meniu, folosind ID-urile predefinite
        if (item.getItemId() == R.id.addBook) {
            Book book = new Book(4, "Test", "test", "test", "book1");
            bookListAdapter.getBooksList().getBooks().add(book);
            bookListAdapter.notifyDataSetChanged();
        } else if (item.getItemId() == R.id.removeBook) {
            bookListAdapter.getBooksList().getBooks().remove(info.position);
            bookListAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ShowBookActivity.class);
        intent.putExtra("bookIndex", position);
        startActivity(intent);

    }

    public	boolean	onCreateOptionsMenu(Menu menu)
    {
        //Inflate the	menu;	this	adds	items	to	the	action	bar	if	it	is	present.
        getMenuInflater().inflate(R.menu.options_list,	menu);
        return	true;
    }

    public	boolean	onOptionsItemSelected(MenuItem	item) {
        //	Handle	action	bar	item	clicks	here.	The	action	bar	will
        //	automatically	handle	clicks	on	the	Home/Up	button,	so	long
        //	as	you	specify	a	parent	activity	in	AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.singOut)
        {
            singOut();
        }
        else
            if (id == R.id.resetList)
            {
                bookListAdapter.getBooksList().restart();
                bookListAdapter.notifyDataSetChanged();
            }
            else
            if (id == R.id.clearFavorites)
            {
                for (Book b : bookListAdapter.getBooksList().getBooks())
                {
                    b.setFavorite(false);
                }
            }
            return	super.onOptionsItemSelected(item);
    }


    private void singOut()
    {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        swapMainActivity();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }

    private void swapMainActivity()
    {
        Intent intent = new Intent(this,LoginActivity.class);
        this.startActivity(intent);
    }
}
