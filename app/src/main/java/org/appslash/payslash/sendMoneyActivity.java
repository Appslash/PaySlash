package org.appslash.payslash;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class sendMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);
    }
    private Uri ussdToCallableUri(String ussd) {

        String uriString = "";

        if(!ussd.startsWith("tel:"))
            uriString += "tel:";

        for(char c : ussd.toCharArray()) {

            if(c == '#')
                uriString += Uri.encode("#");
            else
                uriString += c;
        }

        return Uri.parse(uriString);
    }
    /** Called when the user touches the button */
    public void sendbymobilenumber(View view)
    {
        EditText recieverphonenumber = (EditText) findViewById(R.id.txtrecieverphonenumber);
        EditText amount = (EditText) findViewById(R.id.txtamounttosend);
        Intent callIntent = new Intent(Intent.ACTION_CALL, ussdToCallableUri("*99*1*1*"+recieverphonenumber.getText()+"*"+amount.getText()+"*1#"));
        startActivity(callIntent);
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (intentResult!=null){
            if(intentResult.getContents()==null){
                Toast.makeText(this,"Scan Cancelled",Toast.LENGTH_LONG).show();
            }
            else{
                String scannedData=intentResult.getContents();
                Toast.makeText(this,intentResult.getContents(),Toast.LENGTH_LONG).show();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label",scannedData);
                clipboard.setPrimaryClip(clip);
            }


        }
    }

}
