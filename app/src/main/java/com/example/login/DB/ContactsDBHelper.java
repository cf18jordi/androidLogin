package com.example.login.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.login.DB.ContactsContract.*;
import com.example.login.Model.Personaje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.crypto.AEADBadTagException;

public class ContactsDBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "onepiece.db";


    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ContactsEntry.TABLE_NAME + "(" +
                    ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ContactsEntry.COLUMN_NAME_TITLE + " TEXT,)";
                    //ContactsEntry.COLUMN_NAME_TITLE2 + " TEXT," +
                    //ContactsEntry.COLUMN_NAME_TITLE3 + " TEXT," +
                    //ContactsEntry.COLUMN_NAME_TITLE4 + " TEXT)";

    public void dropDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + ContactsEntry.TABLE_NAME);
    }

    public void insertContact(SQLiteDatabase db, Personaje c){
        //Check the bd is open
        if (db.isOpen()){

            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ContactsEntry.COLUMN_NAME_TITLE, c.getNom());
            //values.put(ContactsEntry.COLUMN_NAME_TITLE2, c.getPoder());
            //values.put(ContactsEntry.COLUMN_NAME_TITLE3, c.getCapita());
            //values.put(ContactsEntry.COLUMN_NAME_TITLE4, c.getRecompensa());

            db.insert(ContactsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");

        }
    }

    public ArrayList<Personaje> getAllData(SQLiteDatabase db) {
        ArrayList<Personaje> array_noms = new ArrayList<>();

        Cursor resultSet = db.rawQuery("select * from Personaje", null);
        if (resultSet.moveToFirst()) {
            do {
                String name = resultSet.getString(1);
                //String power = resultSet.getString(2);
                //String boss = resultSet.getString(3);
                //String money = resultSet.getString(4);


                array_noms.add(new Personaje(name));
            } while (resultSet.moveToNext());
        }
        resultSet.close();
        return array_noms;
    }


  /*  public ArrayList<Personaje> getAllData(SQLiteDatabase db){
        //Crear una arraylist buida
        String refreshArray[];
        //Fer la consulta sql
        try {
            Class.forName("com.example.login.Model.Personaje").newInstance();
        } catch (Exception ex) {
            System.out.println("Can't connect to BBDD");
        }
        try {

            Connection connection = Personaje.getConnection(onUpgrade();ersonaje);

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM personatge");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(refreshArray);
            }

            rs.close();
            statement.close();
            connection.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        //Parsejar tots els reultats (cursor)

        //retornar l'array
    } */


}
