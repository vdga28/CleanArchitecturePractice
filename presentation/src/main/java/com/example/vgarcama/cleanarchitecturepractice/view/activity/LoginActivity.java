package com.example.vgarcama.cleanarchitecturepractice.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.example.vgarcama.cleanarchitecturepractice.R;
import com.example.vgarcama.cleanarchitecturepractice.di.HasComponent;
import com.example.vgarcama.cleanarchitecturepractice.di.components.DaggerUserComponent;
import com.example.vgarcama.cleanarchitecturepractice.di.components.UserComponent;


public class LoginActivity extends BaseActivity implements HasComponent<UserComponent> {

    private UserComponent mUserComponent;
    public static Activity activity;


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        injectView(this);
        this.mUserComponent = DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        initUI();
    }

    @Override
    public UserComponent getComponent() {
        return mUserComponent;
    }

    @Override
    public Context context() {
        return LoginActivity.this;
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showErrorNetworkMessage(String message, String screen) {

    }

    @Override
    public void initUI() {
        super.initUI();
        navigator.showLoginFragment(getSupportFragmentManager());
    }
}
