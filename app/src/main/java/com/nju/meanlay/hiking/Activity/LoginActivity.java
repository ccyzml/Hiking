package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nju.meanlay.hiking.App;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;

public class LoginActivity extends BaseActivity {
    private ProgressBar loginProgressBar;
    private Button loginBtn,registerBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginProgressBar = findViewById(R.id.login_progress_bar);
        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginProgressBar.setVisibility(View.VISIBLE);
                loginProgressBar.setVisibility(View.INVISIBLE);
                User user = new User();
                user.setNickName("Meanlay");
                user.setUniversity("南京大学");
                user.setCollege("软件学院");
                user.setIntroduction("haahahahahahahah");
                App.getInstance().setUser(user);
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);


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
