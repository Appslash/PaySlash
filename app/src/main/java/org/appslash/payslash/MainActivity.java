package org.appslash.payslash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private EditText mEditTextNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Resources.Theme theme = super.getTheme();
        theme.applyStyle(R.style.SplashScreenTheme, true);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), dashboard.class);
                startActivity(i);
                finish();
            }
        }, 2000);

        //mEditTextNumber = findViewById(R.id.mEditTextNumber);
    }
//    public void dialUpBalance(View view) {
//        //dialUpBalance1();
//        startService(new Intent(this, USSDService.class));
//        dailNumber("99*1*3");
//    }
//    private void dailNumber(String code) {
//        String ussdCode = "*" + code + Uri.encode("#");
//        if (ContextCompat.checkSelfPermission(MainActivity.this,
//                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(MainActivity.this,
//                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
//        } else {
//            startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + ussdCode)));
//            }
//
//        }


//    public void dialUpBalance1() {
//
//        String number = mEditTextNumber.getText().toString();
//        String ussd="";
//        if (number.trim().length() > 0) {
//
//            if (ContextCompat.checkSelfPermission(MainActivity.this,
//                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(MainActivity.this,
//                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
//            } else {
//                for(char c : number.toCharArray()) {
//
//                    if(c == '#')
//                        ussd += Uri.encode("#");
//                    else
//                        ussd += c;
//                }
//                String dial = "tel:" + ussd;
//                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
//            }
//
//        } else {
//            Toast.makeText(MainActivity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                dialUpBalance();
//            } else {
//                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


}
