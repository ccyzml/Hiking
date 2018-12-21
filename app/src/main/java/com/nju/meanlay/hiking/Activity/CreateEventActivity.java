package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.R;

public class CreateEventActivity extends BaseActivity {

    private Button createEventBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_event);
        enableBack();

        createEventBtn = findViewById(R.id.create_event_btn);

        createEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateEventActivity.this,EventDetailActivity.class);
                Event event = DataCenter.getInstance().getEvents()[0];
                intent.putExtra("event",event);
                startActivity(intent);
            }
        });

    }
}
