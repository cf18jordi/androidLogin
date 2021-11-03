package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SystemClock.sleep(200);
        setTheme(R.style.Theme_Login);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogIn = findViewById(R.id.btnLogIn);
        EditText txtUsername = findViewById(R.id.txtUsername);
        EditText txtPassword = findViewById(R.id.txtPassword);
        TextView txtResult = findViewById(R.id.txtResult);

        Intent intent = new Intent(this, MainMenu.class);

        final Button button = findViewById(R.id.btnLogIn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("1234")
                && txtPassword.getText().toString().equals("1234")){
                    Log.i("Test", "Login correcte");
                    txtResult.setText("Login corecte");
                    startActivity(intent);
                }else{
                    Log.i("Test", "Login incorrecte");
                    txtResult.setText("Login incorecte");
                }
            }
        });
    }

}

