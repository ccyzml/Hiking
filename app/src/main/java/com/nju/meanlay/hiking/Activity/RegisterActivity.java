package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nju.meanlay.hiking.R;

public class RegisterActivity extends BaseActivity {
    private Button register_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        enableBack();

        register_btn = findViewById(R.id.register_done_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                RegisterActivity.this.finish();
            }
        });
    }
}
