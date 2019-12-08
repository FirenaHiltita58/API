package com.example.gangguanpsikologis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.txt_username);
        password = (EditText) findViewById(R.id.txt_password);
        btnLogin = (Button)findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("admin")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN BERHASIL",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, Home.class);
                    Login.this.startActivity(intent);
                    finish();
                }
            }

        });

    }
}
