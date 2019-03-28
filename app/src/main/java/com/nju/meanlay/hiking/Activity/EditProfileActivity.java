package com.nju.meanlay.hiking.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.nju.meanlay.hiking.Model.TestUser;
import com.nju.meanlay.hiking.Model.User;
import com.nju.meanlay.hiking.R;
import com.nju.meanlay.hiking.View.CustomItemView;

public class EditProfileActivity extends BaseActivity {
    private CustomItemView nickNameV,universityV,collegeV,descriptionV;
    private Button completeV;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        enableBack();

        nickNameV = findViewById(R.id.nickname);
        universityV = findViewById(R.id.university);
        collegeV = findViewById(R.id.college);
        descriptionV = findViewById(R.id.description);


        User user = TestUser.getUser();
        nickNameV.setContent(user.getNickName());
        universityV.setContent(user.getUniversity());
        collegeV.setContent(user.getCollege());
        descriptionV.setContent(user.getIntroduction());
        completeV  = findViewById(R.id.complete);
        completeV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setNickName(nickNameV.getContent());
                user.setUniversity(universityV.getContent());
                user.setCollege(collegeV.getContent());
                user.setIntroduction(descriptionV.getContent());
                finish();
            }
        });
    }
}
