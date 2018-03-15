package com.example.vgarcama.cleanarchitecturepractice.navigation;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.vgarcama.cleanarchitecturepractice.R;
import com.example.vgarcama.cleanarchitecturepractice.view.activity.SignInActivity;
import com.example.vgarcama.cleanarchitecturepractice.view.fragment.LoginFragment;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {

  @Inject
  Navigator() {
    //empty
  }

  public void showLoginFragment(FragmentManager fragmentManager) {
    LoginFragment loginFragment = new LoginFragment();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.fragment_container, loginFragment);
    fragmentTransaction.commitAllowingStateLoss();
  }

  public void navigateToSignIn(Context context) {
    if (context != null) {
      Intent intentToLaunch = SignInActivity.getCallingIntent(context);
      context.startActivity(intentToLaunch);
    }
  }

}
