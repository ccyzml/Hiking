package com.nju.meanlay.hiking.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nju.meanlay.hiking.App;
import com.nju.meanlay.hiking.DB.DataCenter;
import com.nju.meanlay.hiking.Manifest;
import com.nju.meanlay.hiking.Model.Event;
import com.nju.meanlay.hiking.Model.EventMember;
import com.nju.meanlay.hiking.R;
import com.nju.meanlay.hiking.View.CustomItemView;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class CreateEventActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks{

    public static final int REQUEST_CODE_CHOOSE  = 1;
    private static final int REQUEST_CODE_PERMISSION = 2;
    private Button createEventBtn;
    private FrameLayout choosePhotoFL;
    private ImageView photoIV;
    private List<Uri> mSelected;
    private String photoUrl;
    private EditText memberCountET,feeET,locationET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_create_event);
        enableBack();

        createEventBtn = findViewById(R.id.create_event_btn);
        choosePhotoFL = findViewById(R.id.choose_photo);
        memberCountET = findViewById(R.id.member_count_create_event);
        feeET = findViewById(R.id.fee_create_event);
        locationET = findViewById(R.id.location_create_event);
        choosePhotoFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               requestPermissions();
            }
        });
        photoIV = findViewById(R.id.photo_create_event_iv);
        createEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkCompleteness()){
                    Intent intent = new Intent(CreateEventActivity.this,EventDetailActivity.class);
                    intent.putExtra("event",createEvent());
                    startActivity(intent);
                    CreateEventActivity.this.finish();
                }
            }
        });

    }

    private Boolean checkCompleteness(){
        if ((photoUrl != null)&&(!memberCountET.getText().equals(""))&&(!feeET.getText().equals(""))&&(!locationET.getText().equals(""))){
            return true;
        }else {
            Toast.makeText(this,"请填写完整",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private Event createEvent() {
        Event event = new Event();
        event.setLocation(locationET.getText().toString());
        event.setFee(Float.parseFloat(feeET.getText().toString()));
        event.setDate("2018-1-1");
        event.setImgUrl(R.mipmap.error_default+"");
        event.setTitle("NEW");
        event.setWaitingMembers(new EventMember[0]);
        EventMember member = new EventMember();
        member.setUser(App.getInstance().getUser());
        EventMember[] joinedMembers = new EventMember[1];
        joinedMembers[0] = member;
        event.setJoinedMembers(joinedMembers);
        return event;
    }

    private void openPhotos() {
        Matisse.from(CreateEventActivity.this)
                .choose(MimeType.allOf())
                .countable(true)
                .maxSelectable(1)
                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.nav_header_height))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .thumbnailScale(0.85f)
                .imageEngine(new GlideEngine())
                .forResult(REQUEST_CODE_CHOOSE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CHOOSE && resultCode == RESULT_OK) {
            mSelected = Matisse.obtainResult(data);
            photoUrl = mSelected.get(0).toString();
            Glide.with(this).load(Uri.parse(photoUrl)).centerCrop().into(photoIV);
        }
    }

    private void requestPermissions() {
        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        //判断有没有权限
        if (EasyPermissions.hasPermissions(this, perms)) {
            openPhotos();
        } else {
            // 如果没有权限, 就去申请权限
            // this: 上下文
            // Dialog显示的正文
            // RC_CAMERA_AND_RECORD_AUDIO 请求码, 用于回调的时候判断是哪次申请
            // perms 就是你要申请的权限
            EasyPermissions.requestPermissions(this, "需要权限选择相片", REQUEST_CODE_PERMISSION, perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        openPhotos();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
    }
}
