package com.example.mycontactmanager.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mycontactmanager.R;
import com.example.mycontactmanager.model.Contact;
import com.example.mycontactmanager.util.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = String.format("CREATE TABLE %s(%d INTEGER PRIMARY KEY, %s TEXT, %s TEXT)", Util.TABEL_NAME, Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER);
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = String.valueOf((R.string.db_drop));
        db.execSQL(DROP_TABLE, new String[]{Util.DATABASE_NAME});
        onCreate(db);
    }

    // CRUD Operations
    // Create
    public void addContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();

        //instead hashMap use contentValues recomded
        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME, contact.getName());
        values.put(Util.KEY_PHONE_NUMBER, contact.getPhneNumber());

        //insert into table
        db.insert(Util.TABEL_NAME, null, values);
        //close the connection
        db.close();
    }
    // get a contact
    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABEL_NAME, new String[]{Util.KEY_ID, Util.KEY_NAME, Util.KEY_PHONE_NUMBER}, Util.KEY_ID+"=?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }
        Contact contact = new Contact();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setName(cursor.getString(1));
        contact.setPhneNumber(cursor.getString(2));

        return contact;
    }
}
