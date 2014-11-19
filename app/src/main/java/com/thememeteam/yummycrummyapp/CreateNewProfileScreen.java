package com.thememeteam.yummycrummyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class CreateNewProfileScreen extends Activity {

    EditText nameTxt, passwordTxt, confirmPasswordTxt, emailTxt, bdayTxt, genderTxt;
    //List<Account> Accounts = new ArrayList<Account>();
    YummyCrummyDatabaseHelper dbHelper;
    TestDB testDB;
    private static final String TAG = "CreateNewProfileScreen";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_profile_screen);
        nameTxt = (EditText) findViewById(R.id.txtName);
        passwordTxt = (EditText)findViewById(R.id.txtPassword);
        confirmPasswordTxt = (EditText) findViewById(R.id.txtConfirmPassword);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        bdayTxt = (EditText) findViewById(R.id.txtBday);
        genderTxt = (EditText)findViewById(R.id.txtGender);
        dbHelper = new YummyCrummyDatabaseHelper(getApplicationContext());
        testDB = new TestDB();
        Button facebookBtn = (Button) findViewById(R.id.btnFacebook);
        Button uploadPicBtn = (Button) findViewById(R.id.btnPicture);

        Button testButton;
        testButton = (Button) findViewById(R.id.testButton);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.testButton:
                        testButtonClick();
                        testDB.addAccount(aid.getText(), nameTxt.getText(),passwordTxt.getText(),confirmPasswordTxt.getText(),emailTxt.getText(),bdayTxt.getText(),genderTxt.getText());
                        break;
                }
            }
        });

        final Button submitBtn = (Button) findViewById(R.id.btnSubmit);


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"button has been clicked");
                Account account = new Account(0,
                                              String.valueOf(nameTxt.getText()),
                                              String.valueOf(passwordTxt.getText()),
                                              String.valueOf(confirmPasswordTxt.getText()),
                                              String.valueOf(emailTxt.getText()),
                                              String.valueOf(bdayTxt.getText()),
                                              String.valueOf(genderTxt.getText()));
               dbHelper.createAccount(account);
               //Accounts.add(account);
               Toast.makeText(getApplicationContext(), "Your Account has been created!", Toast.LENGTH_SHORT).show();
            }
        });



        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                submitBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());   //if the name is not empty, enable submit btn
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void testButtonClick()
    {
        //Log.d(TAG, "createNewAccountClick");
        startActivity(new Intent("com.thememeteam.yummycrummyapp.TestDB"));
        //addAccount(nameTxt.getText(),passwordTxt.getText(),confirmPasswordTxt.getText(),emailTxt.getText(),bdayTxt.getText(),genderTxt.getText());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_new_profile_screen, menu);
        return true;
    }



   // public class AccountListAdapter extends ArrayAdapter<Account>{
      //  public AccountListAdapter(){
            //super (CreateNewProfileScreen.this);
       // }
   // }

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
