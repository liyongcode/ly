package com.app.joyfulkitchen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;

import com.app.joyfulkitchen.activity.R;

public class MySettingActivity extends Activity implements OnClickListener  {

    /**
     * 返回
     */
    private ImageView title_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_setting);
        title_back = (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                this.finish();
                break;
            default:
                break;
        }
    }
}
