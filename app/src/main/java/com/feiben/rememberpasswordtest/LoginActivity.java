package com.feiben.rememberpasswordtest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ${FeiBen} on 2016/6/13.
 */
public class LoginActivity extends BaseActivity {

    private EditText accountEditText;
    private EditText passwordEditText;
    private CheckBox rememberPassword;
    private Button login;

    private boolean isRemember;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEditText = (EditText) findViewById(R.id.account_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        rememberPassword = (CheckBox) findViewById(R.id.remember_password);
        login = (Button) findViewById(R.id.login);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isRemember = preferences.getBoolean("rememberPassword",false);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    editor = preferences.edit();
                    if(rememberPassword.isChecked()){
                        editor.putString("account",account);
                        editor.putString("password",password);
                        editor.putBoolean("rememberPassword",true);
                    }else{
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(isRemember){
            accountEditText.setText(preferences.getString("account",""));
            passwordEditText.setText(preferences.getString("password",""));
            rememberPassword.setChecked(isRemember);
        }
    }
}
