package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {

    String[] aMemo ={"1. click to edit","2. long click to clear","3. ","4. ","5. ","6. ","7. "};
    ListView lv;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv =(ListView) findViewById(R.id.listView);
        aa =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, aMemo);

        lv.setAdapter(aa);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> a, View v, int pos, long id) {
        Intent it = new Intent(this,edit.class);
        it.putExtra("No.",pos+1);
        it.putExtra("context",aMemo[pos]);
        startActivityForResult(it,pos);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> a, View v, int pos, long id) {
        aMemo[pos] =(pos+1)+".";
        aa.notifyDataSetChanged();//update context
        return false;
    }


    protected void onActivityResult(int requestCode,int resultCode,Intent it)
    {
        if(resultCode == RESULT_OK){
            aMemo[requestCode] = it.getStringExtra("context");
            aa.notifyDataSetChanged();
        }



    }
}
