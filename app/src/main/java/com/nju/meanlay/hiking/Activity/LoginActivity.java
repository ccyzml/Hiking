package com.nju.meanlay.hiking.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.nju.meanlay.hiking.App;
import com.nju.meanlay.hiking.Model.TestUser;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;


public class LoginActivity extends BaseActivity {
    private ProgressBar loginProgressBar;
    private Button loginBtn,registerBtn;

    EditText accountV;
    EditText passwordV;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginProgressBar = findViewById(R.id.login_progress_bar);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);
        accountV = findViewById(R.id.account);
        passwordV = findViewById(R.id.password);
        accountV.setText("18816214422");
        passwordV.setText("123456");

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler  = new Handler();
                loginProgressBar.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loginProgressBar.setVisibility(View.INVISIBLE);
                        User user = TestUser.getUser();
                        App.getInstance().setUser(user);
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        LoginActivity.this.finish();
                    }
                },1000);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



    }

}
