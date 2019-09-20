package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class edit extends AppCompatActivity {

    TextView txv;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent it = getIntent();


        int no = it.getIntExtra("No.",0);
        String s = it.getStringExtra("context");


        txv =(TextView) findViewById(R.id.textView);
        //txv.setText(no+".");

        txv.setText(s.substring(0,2));



        edt = (EditText) findViewById(R.id.editText);

        if(s.length() > 3 )
            edt.setText(s.substring(3));

    }


    public void onCancel(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
        //it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    public void onSave(View v)
    {
        Intent it2 =new Intent();
        it2.putExtra("context",txv.getText()+" "+edt.getText());
        setResult(RESULT_OK,it2);
        finish();
    }




}
