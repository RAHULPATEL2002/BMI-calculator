package com.example.bmicalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Result_t ;
        Button Button_res ;
        EditText edittext_wt,height_ft,height_in;
        LinearLayout llMain;
        llMain=findViewById(R.id.LinearLayout);

        edittext_wt=findViewById(R.id.edittext_wt);
        height_ft=findViewById(R.id.edittext_ft);
        height_in=findViewById(R.id.edittext_in);
        Result_t=findViewById(R.id.txt_result);
        Button_res=findViewById(R.id.button_res);

        Button_res.setOnClickListener(v -> {
            int wt=Integer.parseInt(edittext_wt.getText().toString());
            int ft=Integer.parseInt(height_ft.getText().toString());
            int in=Integer.parseInt(height_in.getText().toString());

            int totalIn=ft*12+in;
            double total_cm=totalIn*2.53;
            double totalM=total_cm/100;
            double bmi=wt/(totalM*totalM);

            if(bmi>25){
                Result_t.setText(R.string.dec1);
                llMain.setBackgroundColor(getResources().getColor(R.color.OverHeight));
            } else if (bmi<18) {
                Result_t.setText(R.string.dec2);
                llMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
            }else{
                Result_t.setText(R.string.dec3);
                llMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
            }
        });

    }
}