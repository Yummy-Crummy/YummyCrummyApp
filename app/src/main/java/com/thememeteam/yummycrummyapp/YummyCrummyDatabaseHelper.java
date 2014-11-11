package com.thememeteam.yummycrummyapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lauren on 11/9/2014.
 */
public class YummyCrummyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "yummycrummydb",
    TABLE_ACCOUNT = "accounts",
    COLUMN_ACOUNT_ID = "id",
    COLUMN_NAME = "name",
    COLUMN_PASSWORD = "password",
    COLUMN_CONFIRM_PASSWORD = "confirmPassword",
    COLUMN_EMAIL = "email",
    COLUMN_BIRTHDAY = "bday",
    COLUMN_GENDER = "gender";

    private static final int DATABASE_VERSION = 1;

    public YummyCrummyDatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table accounts  (" + " id integer primary key autoincrement,namme String, password String, confirmPassword String, email String, bday String, gender String)");

        //db.execSQL("create table profile (" + "profileid integer primary key autoincrement, acctid integer foreign key, fname varchar(25), bday varchar(10), gender varchar(20)");
        //db.execSQL("create table preferences (" + "prefid integer primary key autoincrement, profileid integer foreign key, restaurant varchar(50), dish varchar(50),rating integer, loc varchar(50)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ACCOUNT);

        onCreate(db);
        //Implement schema changes and data massage here when upgrading
    }

    public long createAccount(Account myAccount)
    {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, myAccount.getAcctName());
        values.put(COLUMN_PASSWORD, myAccount.getAcctPW());
        values.put(COLUMN_CONFIRM_PASSWORD, myAccount.getAcctConPW());
        values.put(COLUMN_EMAIL, myAccount.getAcctEmail());
        values.put(COLUMN_BIRTHDAY, myAccount.getAcctBday());
        values.put(COLUMN_GENDER, myAccount.getAcctGender());

       return getWritableDatabase().insert(TABLE_ACCOUNT, null, values);
    }

   /* public Account getAccount(int id){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_ACCOUNT, new String[] {KEY_ID, KEY_NAME, KEY_PASSWORD, KEY_CONFIRM_PASSWORD, KEY_EMAIL, KEY_BIRTHDAY, KEY_GENDER},KEY_ID +"=?", new String[] {String.valueOf(id)}, null, null, null, null );

        if (cursor != null)
            cursor.moveToFirst();

        Account account = new Account(Integer.parseInt(cursor.getString(0)), //id
                                      cursor.getString(1), //name
                                      cursor.getString(2), //password
                                      cursor.getString(3), //confirmPassword
                                      cursor.getString(4), //email
                                      cursor.getString(5), //birthday
                                      cursor.getString(6)); //gender
        db.close();
        cursor.close();
        return account;
    }
    */

   /* public void deleteAccount(Account account){
        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_ACCOUNT, KEY_ID + "=?", new String[] {String.valueOf(account.getAcctId())});
        db.close();
    }
    */
    /*
    public int getAccountCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM" + TABLE_ACCOUNT, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;
    }
    */
    /*
    public int updateAccount(Account myAccount){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, myAccount.getAcctName());
        values.put(KEY_PASSWORD, myAccount.getAcctPW());
        values.put(KEY_CONFIRM_PASSWORD, myAccount.getAcctConPW());
        values.put(KEY_EMAIL, myAccount.getAcctEmail());
        values.put(KEY_BIRTHDAY, myAccount.getAcctBday());
        values.put(KEY_GENDER, myAccount.getAcctGender());

        return db.update(TABLE_ACCOUNT, values, KEY_ID + "=?",new String[] {String.valueOf(myAccount.getAcctId())});

    }
    */
    /*

    /*public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<Account>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM" + TABLE_ACCOUNT, null);

        if (cursor.moveToFirst()){
            do {
                Account account = new Account(Integer.parseInt(cursor.getString(0)), //id
                        cursor.getString(1), //name
                        cursor.getString(2), //password
                        cursor.getString(3), //confirmPassword
                        cursor.getString(4), //email
                        cursor.getString(5), //birthday
                        cursor.getString(6)); //gender
                accounts.add(account);
            }
            while (cursor.moveToNext());
        }
        return accounts;
    }
    */
}
