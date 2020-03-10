package com.kolliadit.customapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String,String> qa;
    Button sub;
    EditText responseText;
    TextView displayText;
    TextView qText;
    RadioGroup radio;

    int[] scores;
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref= getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
        setContentView(R.layout.activity_main);
        sub=findViewById(R.id.btnDisplay);
        final int[] scores=new int[]{0,0,0,0};
        qa=new HashMap<String,String>();
        for(int num=0;num<4;num++)
            scores[num]=pref.getInt(""+num,0);
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int selectedId = radio.getCheckedRadioButtonId();
                scores[selectedId]++;
                editor.putInt(selectedId+"",scores[selectedId]);
                editor.commit();


            }
        });



    }
}
