package com.atilano.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUname,etPword;
    Button btnSave, btnDisplay;
    TextView tvDisplay;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUname = (EditText) findViewById(R.id.etUname);
        etPword = (EditText) findViewById(R.id.etPword);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo (View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", etUname.getText().toString());
        editor.putString("pwd", etPword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences", Toast.LENGTH_LONG).show();
    }

    public void loadInfo (View view){
        String user = preferences.getString("user", "");
        String pwd = preferences.getString("pwd","");
        tvDisplay.setText("User is " + user + " and the password is " + pwd);

    }
}
