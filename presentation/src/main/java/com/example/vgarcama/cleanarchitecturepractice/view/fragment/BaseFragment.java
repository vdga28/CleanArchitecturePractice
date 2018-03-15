package com.example.vgarcama.cleanarchitecturepractice.view.fragment;
import android.widget.Toast;

import com.example.vgarcama.cleanarchitecturepractice.di.HasComponent;
import com.example.vgarcama.cleanarchitecturepractice.view.BaseView;

public abstract class BaseFragment extends android.support.v4.app.Fragment implements BaseView {

  protected void showToastMessage(String message) {
    Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
  }

  @SuppressWarnings("unchecked")
  protected <C> C getComponent(Class<C> componentType) {
    return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
  }

  @Override
  public void initUI() {

  }
}
