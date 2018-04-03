package com.android.lab.sampleeasypermission;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int TAKE_PICTURE = 1;
    private static final int CAMERA_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //making requesst for permission
        EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera), CAMERA_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, MainActivity.this);
    }

    //handling call backs of the request
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

        Toast.makeText(getApplicationContext(),"Permission Granted",Toast.LENGTH_SHORT).show();

    }

    //handling call backs of the request

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

        Toast.makeText(getApplicationContext(),"Permission Denied",Toast.LENGTH_SHORT).show();


    }
}
