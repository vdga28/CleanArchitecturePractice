package com.example.vgarcama.cleanarchitecturepractice.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.vgarcama.cleanarchitecturepractice.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
