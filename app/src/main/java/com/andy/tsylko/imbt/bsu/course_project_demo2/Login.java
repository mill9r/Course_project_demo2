package com.andy.tsylko.imbt.bsu.course_project_demo2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button loginButton;
    private EditText cardNumber;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cardNumber = (EditText) findViewById(R.id.input_cardNumber);

        password = (EditText) findViewById(R.id.input_password);


        loginButton = (Button) findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cardN = Integer.parseInt(cardNumber.getText().toString());
                String pass = password.getText().toString();

                if (cardN == 12345) {

                    if (pass.equals("qwerty")) {
                        Intent intent = new Intent(Login.this, MainMenu.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, pass, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Login.this, cardN, Toast.LENGTH_SHORT).show();
                }
            }
        });


        Typeface t = Typeface.createFromAsset(getAssets(),
                "fonts/Intro.ttf");
        cardNumber.setTypeface(t, Typeface.NORMAL);
        password.setTypeface(t, Typeface.NORMAL);
        loginButton.setTypeface(t, Typeface.BOLD);

    }

}

