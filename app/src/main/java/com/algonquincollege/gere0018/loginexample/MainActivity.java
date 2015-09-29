package com.algonquincollege.gere0018.loginexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

/**
 * Adding two stars on the top generates a java doc. so it is different from the regular comment.
 *
 * */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = (Button) findViewById(R.id.loginBtn);
        //add a clicklistener to the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Create a variable and get the edittext user email element by id
                EditText userEmailText = (EditText) findViewById(R.id.userEmail);
                //convert text input into a string.
                String userEmail = userEmailText.getText().toString();

                //same for password
                EditText userPasswordText = (EditText) findViewById(R.id.userPassword);
                String userPassword = userPasswordText.getText().toString();



              //  When the user clicks on the login button, the following code will run and decide
              // what happens in different scenarios.
            if(!validateUserEmail(userEmail)){
                userEmailText.setError("Invalid email address");
                userEmailText.requestFocus();
                Toast.makeText(getApplicationContext(),
                        "This is not a valid email address. Please re-enter your user Email.",
                        Toast.LENGTH_LONG)
                        .show();
            }else if(!validateUserPassword(userPassword)){
                userPasswordText.setError("Invalid Password");
                userPasswordText.requestFocus();
                Toast.makeText(getApplicationContext(),
                        "This is not a valid password. Please re-enter your password.",
                        Toast.LENGTH_LONG)
                        .show();

            }else{
                Toast.makeText(getApplicationContext(),
                        "Welcome!!" +
                                "You are now logged in." + userEmail +
                                "User name: " +
                                "Password: " + userPassword,
                        Toast.LENGTH_LONG)
                        .show();
            }


            }
            //the username is mandatory
            //the length of the username must be exactly 8 characters in length
            // each of the first 2 positions can only be lower-case alphabetic characters (a-z)
               public boolean validateUserEmail(String userEmail) {
                   if (!userEmail.isEmpty()) {
                       if(userEmail.length() == 8
                               &&  Character.isLowerCase(userEmail.charAt(0))
                               && Character.isLowerCase(userEmail.charAt(1))){
                           return true;

                       }else {
                           return false;

                       }


                   }else {
                       //user email is empty.
                       return false;
                   }


               }
            public boolean validateUserPassword(String userPassword) {
                if (!userPassword.isEmpty()) {
                    if(userPassword.length() >= 5){
                        return true;
                    }else{
                        return false;
                    }

                }else {
                    //password field is empty.
                    return false;
                }


            }
        });



        //*******************************************************************************
        // This code is from a previous assignment. Saved for learning purposed.
        //*******************************************************************************
        //same for checkbox but instead of string this is a boolean.
//                CheckBox rememberMeCheckbox = (CheckBox) findViewById(R.id.isRememberMe);
//                Boolean isChecked = rememberMeCheckbox.isChecked();

//                if(userEmail.isEmpty()){
//                    userEmailText.setError("Enter your email address");
//                    userEmailText.requestFocus();
//                    return;
//                }
//                Toast.makeText(getApplicationContext(),
//                        "User Email: " + userEmail +
//                        "User Password: " + userPassword +
//                        "Remember Me Button: " + isChecked,
//                        Toast.LENGTH_LONG)
//                        .show();
//
//                Toast.makeText(getApplicationContext(),
//                        "loginButton :: onClick()",
//                        Toast.LENGTH_SHORT)
//                        .show();
//               // display a short Toast message to the user; display an appropriate message to the user
//                Toast.makeText(getApplicationContext(),
//                        "Please wait while we confirm your credentials",
//                        Toast.LENGTH_SHORT)
//                        .show();



//        Button forgotPassword = (Button) findViewById(R.id.fogotPasswordBtn);
//        forgotPassword.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),
//                        "Forgot My Password? :: onClick()",
//                        Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
