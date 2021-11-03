package com.example.login.DB;

import android.provider.BaseColumns;

public class ContactsContract {
    private ContactsContract(){}
    public static class ContactsEntry implements BaseColumns {
        public static final String TABLE_NAME ="Personaje";
        public static final String ID = "id";
        public static final String COLUMN_NAME_TITLE = "name";
        //public static final String COLUMN_NAME_TITLE2 = "power";
        //public static final String COLUMN_NAME_TITLE3 = "boss";
        //public static final String COLUMN_NAME_TITLE4 = "money";

    }
}

