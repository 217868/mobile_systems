package com.example.univeristyligthhousekeeper.DatabaseModel;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper {
    public static final String DB_NAME = "main.db";
    public static final int DB_VERSION = 1;

    public Database(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }
}
