package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.login.DB.ContactsDBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {

    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creation of the dbHelper
        dbHelper = new ContactsDBHelper(getApplicationContext());
        db = dbHelper.getWritableDatabase();
        //dbHelper.dropDatabase(db);
        //dbHelper.onCreate(db);

        setContentView(R.layout.activity_main_menu);

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        bottomNav.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;

                case R.id.nav_list:
                    selectedFragment = new FragmentList(dbHelper, db);
                    break;

                case R.id.nav_form:
                    selectedFragment = new FragmentForm(dbHelper, db);
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        });



    }
}
