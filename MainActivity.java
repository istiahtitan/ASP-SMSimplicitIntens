package com.example.titan.smsimplicitintens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mTextSms;
    private EditText mTextPhone;
    private String phoneNo;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextSms = findViewById(R.id.edittextSMS);
        mTextPhone = findViewById(R.id.editphoneSMS);
    }

    public void OpenMessage (View view) {
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.putExtra("sms_body", "default content");
        sendIntent.setType("vnd.android-dir/mms-sms");
        startActivity(sendIntent);

    }

    public void SendingMessage (View view) {
        phoneNo = mTextPhone.getText().toString();
        message = mTextSms.getText().toString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNo,null, "message", null, null);

        Toast.makeText(getApplicationContext(), "SMS Anda Telah Terkirim.",
                Toast.LENGTH_LONG).show();
    }
}
