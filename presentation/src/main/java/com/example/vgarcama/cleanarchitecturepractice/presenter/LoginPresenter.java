package com.example.vgarcama.cleanarchitecturepractice.presenter;

import android.text.TextUtils;

import com.example.data.entity.mapper.UserEntity;
import com.example.interactor.Login;
import com.example.interactor.UseCase;
import com.example.model.User;
import com.example.vgarcama.cleanarchitecturepractice.di.PerActivity;
import com.example.vgarcama.cleanarchitecturepractice.view.LoginView;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.subscribers.DefaultSubscriber;
import io.realm.Realm;


@PerActivity
public class LoginPresenter implements Presenter<LoginView> {

    UserEntity userEntity;

    private final UseCase mLoginUseCase;
    private LoginView mView;
    Realm realm;

    @Inject
    public LoginPresenter(@Named("login") UseCase loginUseCase) {
        this.mLoginUseCase = loginUseCase;

    }

    @Override
    public void resume() {
        //Default implementation
    }

    @Override
    public void pause() {
        //Default implementation
    }

    @Override
    public void destroy() {

        mView = null;
    }

    public void setView(LoginView mView) {
        this.mView = mView;
    }


    public void onLoginButtonClicked(String email, String password, String deviceToken) {
        if (validateLogin(email, password)) {
            ((Login) mLoginUseCase).bindParams(email, password, 2, deviceToken);

        }
    }

    private boolean validateLogin(String usuario, String password) {
        return isUser(usuario) && isPasswordCorrect(password);
    }

    private boolean isUser(String usuario) {
        boolean result = true;
        if (TextUtils.isEmpty(usuario)) {

            result = false;
        } else if (usuario.length() < 3 || usuario.contains(" ")) {
            result = false;
        } else {
            hideEmailErrorMessage();
        }
        return result;
    }

    private boolean isPasswordCorrect(String password) {
        boolean result = true;
        if (TextUtils.isEmpty(password)) {
            result = false;
        }  else {
            mView.hidePasswordError();
        }
        return result;
    }

    private void hideEmailErrorMessage() {
        mView.hideEmailError();
    }



    private void hideViewLoading() {
        mView.hideLoading();
    }

    public void viewMainScreen(User user) {
        hideViewLoading();
    }


    private final class LoginSubscriber extends DefaultSubscriber<User> {

        @Override
        public void onStart() {
            showViewLoading();
        }

        @Override
        public void onNext(User user) {

            mView.signInFirebase("sd",user);

        }

        @Override
        public void onError(Throwable e) {
            hideViewLoading();
        }

        @Override
        public void onComplete() {

        }

        private void showViewLoading() {
            mView.showLoading();
        }
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void saveUser(String email, String password){
        userEntity = realm.createObject(UserEntity.class);
        userEntity.setEmail(email);
        userEntity.setPassword(password);
    }
}