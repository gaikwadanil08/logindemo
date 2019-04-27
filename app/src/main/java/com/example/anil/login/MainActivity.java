package com.example.anil.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText mobile;
    private EditText email;
    private EditText password;

     String[] ss = {"+91","+92","+93","+94","+95","+96"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobile = (EditText)findViewById(R.id.et_mobile);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);
        Spinner spin = (Spinner)findViewById(R.id.spinner);

        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,ss);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
    }
    private boolean validateMobile()
    {
        String mobileInput = mobile.getEditableText().toString().trim();
        if(mobileInput.isEmpty())
        {
            mobile.setError("Field Can't be Empty");
            return false;
        }else
        {
            mobile.setError(null);
            return true;
        }
    }
    private boolean validateEmail()
    {
        String emailInput = email.getEditableText().toString().trim();
        if(emailInput.isEmpty())
        {
            email.setError("Field Can't be Empty");
            return false;
        }else
        {
            email.setError(null);
            return true;
        }
    }
    private boolean validatePassword()
    {
        String passInput = password.getEditableText().toString().trim();
        if(passInput.isEmpty())
        {
            password.setError("Field Can't be Empty");
            return false;
        }else
        {
            password.setError(null);
            return true;
        }
    }
    public void confirmInput(View view)
    {
        if(!validateMobile() | !validateEmail() | !validatePassword())
        {
            return;
        }
        String input = "Mobile :" +mobile.getText().toString();
        input+="\n";
        input+="Email :" +email.getText().toString().trim();
        input+="\n";
        input+="Password :" +password.getText().toString();

        Toast.makeText(this,input,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
