package com.example.mada.myapplication;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    Button buttonLogin;
    TextView name_view, password_view;
    TextView error_name, error_password, error_validation;
    EditText name_edit, password_edit;
    boolean isValid;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //assign components
        name_edit = (EditText) findViewById(R.id.name);
        password_edit = (EditText) findViewById(R.id.password);
        buttonLogin = (Button) findViewById(R.id.login);
        name_view = (TextView) findViewById(R.id.Name);
        password_view = (TextView) findViewById(R.id.Password);
        error_name = (TextView) findViewById(R.id.errror_name);
        error_password = (TextView) findViewById(R.id.error_password);
        error_validation = (TextView) findViewById(R.id.error_validation);
        isValid = true;

        //hide elements
        error_name.setVisibility(View.INVISIBLE);
        error_password.setVisibility(View.INVISIBLE);
        error_validation.setVisibility(View.INVISIBLE);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (name_edit.getText().toString().equals("")) {
                    error_name.setText("Name can't be empty");
                    error_name.setVisibility(View.VISIBLE);
                    error_name.setTextColor(Color.RED);
                    isValid = false;
                } else if (name_edit.getText().toString().length() < 4) {
                    error_name.setText("Name is to short");
                    error_name.setVisibility(View.VISIBLE);
                    error_name.setTextColor(Color.RED);
                    isValid = false;
                }

                if (password_edit.getText().toString().equals("")) {
                    error_password.setText("Password can't be empty");
                    error_password.setVisibility(View.VISIBLE);
                    error_password.setTextColor(Color.RED);
                    isValid = false;
                } else {
                    if (password_edit.getText().toString().length() < 4) {
                        error_password.setText("Password is to short");
                        error_password.setVisibility(View.VISIBLE);
                        error_password.setTextColor(Color.RED);
                        isValid = false;
                    }
                }
                if (name_edit.getText().toString().equals("admin") &&
                        password_edit.getText().toString().equals("admin"))
                {
                    error_validation.setText("Login succesfull");
                    error_validation.setVisibility(View.VISIBLE);
                    error_validation.setTextColor(Color.GREEN);
                    Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                    startActivity(intent);

                } else {
                    if (isValid == true) {
                        error_validation.setText("Username or password are incorect");
                        error_validation.setVisibility(View.VISIBLE);
                        error_validation.setTextColor(Color.RED);
                    }
                }
            }

        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
