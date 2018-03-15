package com.example.vgarcama.cleanarchitecturepractice.di.modules;

import android.content.Context;


import com.example.data.cache.UserCache;
import com.example.data.cache.UserCacheImpl;
import com.example.data.executor.JobExecutor;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.vgarcama.cleanarchitecturepractice.AndroidApplication;
import com.example.vgarcama.cleanarchitecturepractice.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton
  Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton
  ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton
  PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton
  UserCache provideUserCache(UserCacheImpl userCache) {
    return userCache;
  }

}
