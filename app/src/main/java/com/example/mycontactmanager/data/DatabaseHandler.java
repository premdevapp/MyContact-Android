package com.example.mycontactmanager.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mycontactmanager.R;
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
}
