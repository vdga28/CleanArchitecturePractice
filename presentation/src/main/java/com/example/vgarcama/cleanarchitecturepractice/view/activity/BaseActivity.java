package com.example.vgarcama.cleanarchitecturepractice.view.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vgarcama.cleanarchitecturepractice.AndroidApplication;
import com.example.vgarcama.cleanarchitecturepractice.di.components.ApplicationComponent;
import com.example.vgarcama.cleanarchitecturepractice.di.modules.ActivityModule;
import com.example.vgarcama.cleanarchitecturepractice.navigation.Navigator;
import com.example.vgarcama.cleanarchitecturepractice.view.BaseView;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

  @Inject
  Navigator navigator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }

  protected void addFragment(int containerViewId, Fragment fragment) {
    final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
    fragmentTransaction.add(containerViewId, fragment);
    fragmentTransaction.commit();
  }

  void injectView(Activity activity) {
    ButterKnife.setDebug(true);
    ButterKnife.bind(activity);
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((AndroidApplication) getApplication()).getApplicationComponent();
  }

  protected ActivityModule getActivityModule() {
    return new ActivityModule(this);
  }

    @Override
    public void initUI() {

    }
}
