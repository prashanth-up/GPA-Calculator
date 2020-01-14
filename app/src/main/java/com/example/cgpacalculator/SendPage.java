package com.example.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendPage extends AppCompatActivity {

    Button sharebut;
    EditText inputNumber;
    EditText inputGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_page);

        sharebut = findViewById(R.id.sharebut);
        inputNumber = findViewById(R.id.inputNumber);
        inputGPA = findViewById(R.id.inputGPA);

        sharebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = inputNumber.getText().toString();
                String message = inputGPA.getText().toString();

                if(phone == null || phone.length() == 0 || phone.length() < 10 || phone.length() >10 || message == null || message.length() == 0 || message.length() > 4 || message.length() < 0 ){
                    Toast.makeText(SendPage.this, "Please Check the Above Parameters", Toast.LENGTH_LONG).show();
                }
                else if ( phone.length() == 10 ){
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phone, null, message,null, null);
                    Toast.makeText(SendPage.this, "Message Sent Successfully!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SendPage.this, "Please Enable the Message Permissions", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
