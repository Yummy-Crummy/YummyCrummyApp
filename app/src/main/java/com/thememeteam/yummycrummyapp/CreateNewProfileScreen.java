package com.thememeteam.yummycrummyapp;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.List;


public class CreateNewProfileScreen extends Activity {

    EditText nameTxt, passwordTxt, confirmPasswordTxt, emailTxt, bdayTxt, genderTxt;
    List<Account> Accounts = new ArrayList<Account>();



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

        Button facebookBtn = (Button) findViewById(R.id.btnFacebook);
        Button uploadPicBtn = (Button) findViewById(R.id.btnPicture);
        final Button submitBtn = (Button) findViewById(R.id.btnSubmit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Accounts.add(new Account(0,nameTxt.getText().toString(),passwordTxt.getText().toString(),confirmPasswordTxt.getText().toString(),emailTxt.getText().toString(),bdayTxt.getText().toString(),genderTxt.getText().toString()));
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
