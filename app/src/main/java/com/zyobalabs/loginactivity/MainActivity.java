package com.zyobalabs.loginactivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText validateEmail,pass;
    Button login;
    String email,email_pattern,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validateEmail = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.button);

        email_pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = validateEmail.getText().toString().trim();
                password = pass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    validateEmail.setError("emailcannot be empty");
                    validateEmail.focusSearch(View.FOCUS_DOWN);

                } else if (email.matches(email_pattern)) {

                    if (TextUtils.isEmpty(password)) {

                        pass.setError("password mustnot be empty");
                        pass.focusSearch(View.FOCUS_DOWN);

                    } else if (password.length() >= 5 && password.length() <= 10) {

                        Toast.makeText(getApplicationContext(), "validation sucess", Toast.LENGTH_LONG).show();

                    } else {
                        pass.setError("password length must be match:5=<password>=10");
                        pass.focusSearch(View.FOCUS_DOWN);
                    }
                } else {

                    validateEmail.setError("email must be in format:abc@abc.com");
                    validateEmail.focusSearch(View.FOCUS_DOWN);

                }


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
