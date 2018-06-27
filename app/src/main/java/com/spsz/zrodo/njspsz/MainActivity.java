package com.spsz.zrodo.njspsz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView img_cz;
    private ImageView img_sz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_cz=(ImageView) findViewById(R.id.img_cz);
        img_sz=(ImageView) findViewById(R.id.img_sz);
        img_sz.setOnClickListener(this);
        img_cz.setOnClickListener(this);
        SharedPreferences sharedPreferences=getSharedPreferences("role",0);
        String role=sharedPreferences.getString("role","");
        if (role.equals("cz")){
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }else if (role.equals("sz")){
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor=getSharedPreferences("role",0).edit();
        switch (v.getId()){
            case R.id.img_cz:
                editor.putString("role","cz");
                editor.apply();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.img_sz:
                editor.putString("role","sz");
                editor.apply();
                Intent inten1=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(inten1);
                finish();
                break;
        }

    }
}
