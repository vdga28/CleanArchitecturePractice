package com.example.vgarcama.cleanarchitecturepractice;

import android.app.Application;

import com.example.vgarcama.cleanarchitecturepractice.di.components.ApplicationComponent;
import com.example.vgarcama.cleanarchitecturepractice.di.components.DaggerApplicationComponent;
import com.example.vgarcama.cleanarchitecturepractice.di.modules.ApplicationModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    this.initializeInjector();
    Realm.init(this);
    RealmConfiguration configuration = new RealmConfiguration.Builder().build();
    Realm.setDefaultConfiguration(configuration);
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

}
