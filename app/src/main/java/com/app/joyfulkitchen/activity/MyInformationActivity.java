package com.app.joyfulkitchen.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.Calendar;


public class MyInformationActivity extends Activity implements View.OnClickListener {

    private LinearLayout dateLinearLayout,city_linearLayout;
    private TextView dateText,city_name;
    private DatePickerDialog dialog;
    private int year,monthOfYear,dayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_information);

        dateLinearLayout = (LinearLayout) findViewById(R.id.dateLinearLayout);
        city_linearLayout = (LinearLayout) findViewById(R.id.city_linearLayout);
        dateText = (TextView) findViewById(R.id.dateText);
        city_name = (TextView) findViewById(R.id.city_name);
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
        dateLinearLayout.setOnClickListener(this);
        city_linearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dateLinearLayout:
                dialog.show();
                break;
            case R.id.city_linearLayout:
                Intent intent = new Intent(MyInformationActivity.this,CityActivity.class);
                startActivityForResult(intent, 5);
                break;
            default:
                break;
        }
    }
  @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(resultCode){
            case RESULT_OK:
                Bundle b=data.getExtras(); //data为B中回传的Intent
                String str=b.getString("FromB");//str即为回传的值
                city_name.setText(str);
                break;
            default:
                break;
        }
    }
}
