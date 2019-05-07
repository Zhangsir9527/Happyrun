package com.zhz.happyrun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        Button toMainActivity =(Button)findViewById(R.id.login_bt1);
        Intent intent_toMainActivity2=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent_toMainActivity2);
//        //透明状态栏          
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        toMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_toMainActivity=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent_toMainActivity);
            }
        });
    }


}
