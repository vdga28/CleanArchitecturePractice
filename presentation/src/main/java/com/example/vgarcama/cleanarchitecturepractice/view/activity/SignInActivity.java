package com.example.vgarcama.cleanarchitecturepractice.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.data.entity.mapper.UserEntity;
import com.example.model.User;
import com.example.vgarcama.cleanarchitecturepractice.R;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.Realm;

public class SignInActivity extends BaseActivity {

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.confirm_password)
    EditText confirmPassword;

    @BindView(R.id.sign_in)
    Button button;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, SignInActivity.class);
    }

    @OnClick (R.id.sign_in)
    public void createUser(){
        UserEntity user = realm.createObject(UserEntity.class);
        user.setEmail(email.getText().toString());
        user.setPassword(password.getText().toString());
    }

    private void getUserInfo () {
        //
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showErrorNetworkMessage(String message, String screen) {

    }
}
