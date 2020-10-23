package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() != null){
            goMainActivity();
        }
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "on click login");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username, password);

            }

            private void loginUser(String username, String password) {
                Log.i(TAG, "attempting to log in user: " + username);
                //NAVIGATE TO MAIN ACTIVITY

                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (e != null){
                            //better error handling
                            Toast.makeText(LoginActivity.this, "Check username or password", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "ISSUE WITH LOGIN", e);
                            return;
                        }
                        goMainActivity();
                        Toast.makeText(LoginActivity.this, "Main", Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });

    }

    private void goMainActivity() {
        Intent i = new Intent (getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }


}
