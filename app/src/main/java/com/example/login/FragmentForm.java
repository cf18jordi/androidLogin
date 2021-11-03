package com.example.login;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.login.DB.ContactsDBHelper;
import com.example.login.Model.Personaje;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentForm#newInstance} factory method to
 * create an instance of this fragment.
 */


public class FragmentForm extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //Creation of the dbHelper
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentForm() {
        // Required empty public constructor
    }

    public FragmentForm(ContactsDBHelper dbHelper, SQLiteDatabase db) {

        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentForm.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentForm newInstance(String param1, String param2) {
        FragmentForm fragment = new FragmentForm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        dbHelper = new ContactsDBHelper(getContext());
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_form, container, false);
        TextView inputForm = root.findViewById(R.id.input_nomDelPersonatge);
        //TextView inputForm2 = root.findViewById(R.id.input_poder);
        //TextView inputForm3 = root.findViewById(R.id.input_capita);
        //TextView inputForm4 = root.findViewById(R.id.input_recompensa);

        Button buttonAdd = root.findViewById(R.id.button_send);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personaje personaje = new Personaje(
                        inputForm.getText().toString(),
                        //inputForm2.getText().toString(),
                        //inputForm3.getText().toString(),
                        //inputForm4.getText().toString()
                );
                dbHelper.insertContact(db, personaje);
            }
        });

        // Inflate the layout for this fragment
        return root;
    }
    //Close the db when the activity onDestroy
    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }

}