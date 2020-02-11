package com.kolliadit.customapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String,String> qa;
    Button sub;
    EditText responseText;
    TextView displayText;
    TextView qText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sub=findViewById(R.id.clickButton);
        responseText=findViewById(R.id.response2EditText);
        displayText=findViewById(R.id.textBox);
        qText=findViewById(R.id.questionBox);
        qa=new HashMap<String,String>();
        final String [] questions= new String[5];

        qa.put("Who is the coolest person you know?","Adit");
        qa.put("What city is TJ in?","Alexandria");
        qa.put("What's the best computer?","A Mac");
        qa.put("Who is the best player in the NBA?","Jordan Poole");
        qa.put("What's the best baseball team?","The Dodgers");

        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("testing onclick:  Good Job");
                Log.i("testButton","Good Job"+responseText.getText().toString());
                double ind= Math.random()*5;
                int index=(int)ind;
                String que=questions[index]    ;
                String an=qa.get(que);
                String useran= String.valueOf(responseText.getText());
                if (useran.equals(an))

                    displayText.setText("Right answer. Proceed");
                else
                    displayText.setText("Wrong answer. Try again");


            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (responseText.getText().toString().equals("TJ")) {
                        displayText.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name.");
                    }
                }
            }
        });


    }
}
