package com.app.joyfulkitchen.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Calendar;


public class MyInformationActivity extends Activity {

    private LinearLayout dateLinearLayout;
    private TextView dateText;
    private DatePickerDialog dialog;
    private int year,monthOfYear,dayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);

        dateLinearLayout = (LinearLayout) findViewById(R.id.dateLinearLayout);
        dateText = (TextView) findViewById(R.id.dateText);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        monthOfYear = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String text = year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
                dateText.setText(text);
            }
        },year,monthOfYear,dayOfMonth);
        dateLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
    }
}
