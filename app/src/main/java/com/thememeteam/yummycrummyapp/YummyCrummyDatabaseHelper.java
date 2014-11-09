package com.thememeteam.yummycrummyapp;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lauren on 11/9/2014.
 */
public class YummyCrummyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "yummycrummydb.sqlite";
    private static final int VERSION = 1;

    private static final String TABLE_ACCOUNT = "account";
    private static final String COLUMN_ACCOUNT_ACCTID = "acctid";

    public YummyCrummyDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table account (" + "acctid integer primary key autoincrement, name string, password varchar(20), email(50), birthday varchar (10), gender varchar(20))");
        db.execSQL("create table profile (" + "profileid integer primary key autoincrement, acctid integer foreign key, fname varchar(25), bday varchar(10), gender varchar(20)");
        db.execSQL("create table preferences (" + "prefid integer primary key autoincrement, profileid integer foreign key, restaurant varchar(50), dish varchar(50),rating integer, loc varchar(50)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Implement schema changes and data massage here when upgrading
    }

    public long insertAccount(Account account)
    {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ACCOUNT_ACCTID, account.getAcctId());
        return getWritableDatabase().insert(TABLE_ACCOUNT, null, cv);
    }
}
