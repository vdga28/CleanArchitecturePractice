package com.example.vgarcama.cleanarchitecturepractice.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.model.User;
import com.example.vgarcama.cleanarchitecturepractice.R;
import com.example.vgarcama.cleanarchitecturepractice.di.components.UserComponent;
import com.example.vgarcama.cleanarchitecturepractice.presenter.LoginPresenter;
import com.example.vgarcama.cleanarchitecturepractice.view.LoginView;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.btn_login)
    Button btnSignIn;

    @BindView(R.id.btn_create)
    Button btnCreate;

    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(UserComponent.class).inject(this);
        presenter.setView(this);
        auth = FirebaseAuth.getInstance();
        initUI();
    }



    @OnClick(R.id.btn_login)
    public void onLoginButtonClick() {
            hideEmailError();
            hidePasswordError();
            String username = getEmail();
            String password = getPassword();
            String pushToken = FirebaseInstanceId.getInstance().getToken();
            presenter.onLoginButtonClicked(username, password, TextUtils.isEmpty(pushToken) ? "" : pushToken);
    }

    @OnClick(R.id.btn_create)
    public void btnCreate() {
        showToastMessage("funciona");
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public void showEmailError(String errorMessage) {

    }

    @Override
    public void hideEmailError() {
        //hideError(tilEmail);
    }

    @Override
    public void showPasswordError(String errorMessage) {

    }

    @Override
    public void hidePasswordError() {
        //hideError(tilPwd);
    }


    @Override
    public void showLoading() {
        if (getActivity() != null) {
           // ((BaseActivity) getActivity()).showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (getActivity() != null) {
            //((BaseActivity) getActivity()).hideLoading();
        }
    }

    @Override
    public void initUI() {

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public Context context() {
        return getActivity().getBaseContext();
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showErrorNetworkMessage(String message, String screen) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();

    }

    @Override
    public void signInFirebase(String token, User user) {
        auth.signInWithCustomToken(token)
                .addOnCompleteListener(getActivity(), (Task<AuthResult> task) -> {

                });
    }
}
