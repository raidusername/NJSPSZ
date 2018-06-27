package com.spsz.zrodo.njspsz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.spsz.zrodo.njspsz.Url.Urls_interfaces;
import com.spsz.zrodo.njspsz.Utils.Http_Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private ImageView imgback;
    private TextView tv_title_name;
    private Button btn_login;
    private EditText edt_password, edt_username;
    private String role;
    RequestBody body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences = getSharedPreferences("role", 0);
        role = sharedPreferences.getString("role", "");
        imgback = (ImageView) findViewById(R.id.img_title_back);
        tv_title_name = (TextView) findViewById(R.id.tv_title_name);
        btn_login = (Button) findViewById(R.id.btn_login);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);
        if (role.equals("cz")) {
            tv_title_name.setText("出证登录");
        } else if (role.equals("sz")) {
            tv_title_name.setText("索证登录");
        }
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences("role", 0).edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_username.getText().toString();
                String pwd = edt_password.getText().toString();
                Log.d("tel", name);
                Log.d("pwd", pwd);
                body = new FormBody.Builder()
                        .add("tel", name)
                        .add("pwd", pwd)
                        .build();
                if (role.equals("cz")) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Http_Util.sendpostRequest(Urls_interfaces.CZlogin(), body, new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(LoginActivity.this, "登录失败,请联系管理员", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    String res = response.body().string();

                                    try {
                                        Log.d("response", res);
                                        JSONObject object = new JSONObject(res);
                                        final String respMsg = object.getString("respMsg");
                                        String code = object.getString("respCode");
                                        if (code.equals("1000000") && respMsg.equals("有此批发商")) {
                                            Intent intent = new Intent(LoginActivity.this, CZActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(LoginActivity.this, respMsg, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            });
                        }
                    }).start();

                } else if (role.equals("sz")) {

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Http_Util.sendpostRequest(Urls_interfaces.SZlogin(), body, new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(LoginActivity.this, "登录失败,请联系管理员", Toast.LENGTH_SHORT).show();
                                        }
                                    });


                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {

                                    String res = response.body().string();
                                    Log.d("response", res);
                                    try {
                                        JSONObject object = new JSONObject(res);
                                        final String respMsg = object.getString("respMsg");
                                        String code = object.getString("respCode");
                                        if (code.equals("1000000") && respMsg.equals("有此零售商")) {
                                            Intent intent = new Intent(LoginActivity.this, SZActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(LoginActivity.this, respMsg, Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            });
                        }
                    }).start();

                }
            }
        });

    }
}
