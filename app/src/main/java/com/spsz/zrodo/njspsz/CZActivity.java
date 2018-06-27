package com.spsz.zrodo.njspsz;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CZActivity extends AppCompatActivity {
    private ImageView img_title_back;
    private TextView tv_title_name;
    private ImageView iv_bluetooth;
    private TextView tv_bluetooth_disc;
    private TextView tv_bluetooth_connect;
    private TextView tv_input;
    private TextView tv_person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cz);
        img_title_back = (ImageView) findViewById(R.id.img_title_back);
        tv_title_name = (TextView) findViewById(R.id.tv_title_name);
        iv_bluetooth = (ImageView) findViewById(R.id.iv_bluetooth);
        tv_bluetooth_disc = (TextView) findViewById(R.id.tv_bluetooth_state_disc);
        tv_bluetooth_connect = (TextView) findViewById(R.id.tv_bluetooth_connect);
        tv_input = (TextView) findViewById(R.id.tv_input);
        tv_person = (TextView) findViewById(R.id.tv_person);
        img_title_back.setVisibility(View.GONE);
        tv_title_name.setText("出证打印");


    }
}
