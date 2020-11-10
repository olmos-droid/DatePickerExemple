package com.example.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private DatePickerDialog picker;
    private EditText textdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        textdate=(EditText) findViewById(R.id.editTextDate);

        textdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                Log.d("#date", "onClick: "+cldr.toString());
                int day=  cldr.get(Calendar.DAY_OF_MONTH);
                Log.d("#dateDay", "onClick: "+day);
                int month= cldr.get(Calendar.MONTH);
                month++; // los meses van del 0 al 11 donde 0 es enero i 11 es diciembre por eso sumamos uno
                Log.d("#dateMonth", "onClick: "+month);
                int year = cldr.get(Calendar.YEAR);
                Log.d("#dateYear", "onClick: "+year);

                picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        textdate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                },year,month,day);
                picker.show();
            }
        });
    }
}