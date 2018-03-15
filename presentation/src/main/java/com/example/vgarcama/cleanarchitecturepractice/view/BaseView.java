package com.example.vgarcama.cleanarchitecturepractice.view;

import android.content.Context;

public interface BaseView {

    void initUI();

    Context context();

    void showErrorMessage(String message);

    void showErrorNetworkMessage(String message, String screen);

}
