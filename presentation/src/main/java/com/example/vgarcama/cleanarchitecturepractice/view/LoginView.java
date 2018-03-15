package com.example.vgarcama.cleanarchitecturepractice.view;

import com.example.model.User;

public interface LoginView extends LoadingView{

    String getEmail();

    String getPassword();

    void showEmailError(String errorMessage);

    void hideEmailError();

    void showPasswordError(String errorMessage);

    void hidePasswordError();

    void signInFirebase(String Token, User user);
}
