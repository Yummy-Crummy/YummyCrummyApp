package com.thememeteam.yummycrummyapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TestDB extends Activity {
    List<Account> Accounts = new ArrayList<Account>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_db, menu);
        return true;
    }


    private void addAccount(int aid,String aName, String aPassword,String aconfirmPassword, String aEmail, String aBday, String aGender)
    {
        Accounts.add(new Account(aid,aName,aPassword,aconfirmPassword,aEmail,aBday,aGender));
    }

    public class AccountListAdapter extends ArrayAdapter<Account>
    {
        public AccountListAdapter()
        {
            super (TestDB.this,R.layout.listview_item, Accounts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent)
        {
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Account currentAccount = Accounts.get(position);

            TextView name = (TextView) view.findViewById(R.id.name);
            name.setText(currentAccount.getAcctName());
            TextView password = (TextView) view.findViewById(R.id.password);
            name.setText(currentAccount.getAcctPW());
            TextView email = (TextView) view.findViewById(R.id.email);
            name.setText(currentAccount.getAcctEmail());
            TextView gender = (TextView) view.findViewById(R.id.gender);
            name.setText(currentAccount.getAcctGender());
            TextView birthday = (TextView) view.findViewById(R.id.birthday);
            name.setText(currentAccount.getAcctBday());

            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
