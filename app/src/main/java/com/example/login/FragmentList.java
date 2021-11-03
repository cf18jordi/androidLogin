package com.example.login;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.login.DB.ContactsDBHelper;
import com.example.login.Model.Personaje;

import java.util.ArrayList;

public class FragmentList extends Fragment {
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    public FragmentList() {
        // Required empty public constructor
    }
    public FragmentList(ContactsDBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View listView = inflater.inflate(R.layout.fragment_list, container, false);

        ArrayList<Personaje> array_noms = dbHelper.getAllData(db);
       /* array_noms.add("Ruffy");
        array_noms.add("Zoro");
        array_noms.add("Nami");
        array_noms.add("Usopp");
        array_noms.add("Sanji");
        array_noms.add("Chopper");
        array_noms.add("Nico Robin");
        array_noms.add("Brook");
        array_noms.add("Jimbe");
        */

        RecyclerView recyclerView = listView.findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return listView;
    }
}