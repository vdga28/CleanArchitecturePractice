/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.vgarcama.cleanarchitecturepractice.presenter;

import android.support.annotation.NonNull;


import com.example.Post;
import com.example.interactor.GetPostList;
import com.example.vgarcama.cleanarchitecturepractice.PostListView;
import com.example.vgarcama.cleanarchitecturepractice.di.PerActivity;
import com.example.vgarcama.cleanarchitecturepractice.mapper.PostModelDataMapper;
import com.example.vgarcama.cleanarchitecturepractice.view.LoadingView;
import com.example.vgarcama.cleanarchitecturepractice.view.model.PostsModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DefaultObserver;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
@PerActivity
public class UserListPresenter implements Presenter<LoadingView> {

  private PostListView viewListView;

  private final GetPostList getUserListUseCase;
  private final PostModelDataMapper userModelDataMapper;

  @Inject
  public UserListPresenter(GetPostList getUserListUserCase,
      PostModelDataMapper userModelDataMapper) {
    this.getUserListUseCase = getUserListUserCase;
    this.userModelDataMapper = userModelDataMapper;
  }

  public void setView(@NonNull PostListView view) {
    this.viewListView = view;
  }

  @Override
  public void resume() {}

  @Override
  public void pause() {}

  @Override
  public void destroy() {
    this.getUserListUseCase.dispose();
    this.viewListView = null;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  public void initialize() {
    this.loadUserList();
  }

  /**
   * Loads all users.
   */
  private void loadUserList() {
    this.hideViewRetry();
    this.showViewLoading();
    //this.getUserList();
  }

  public void onUserClicked(PostsModel postsModel) {
    this.viewListView.viewUser(postsModel);
  }

  private void showViewLoading() {
    this.viewListView.showLoading();
  }

  private void hideViewLoading() {
    this.viewListView.hideLoading();
  }

  private void showViewRetry() {
    this.viewListView.showRetry();
  }

  private void hideViewRetry() {
    this.viewListView.hideRetry();
  }

/*  private void showErrorMessage(ErrorBundle errorBundle) {
    String errorMessage = ErrorMessageFactory.create(this.viewListView.context(),
        errorBundle.getException());
    this.viewListView.showError(errorMessage);
  }*/

  private void showUsersCollectionInView(Collection<Post> usersCollection) {
    final Collection<PostsModel> userModelsCollection =
        this.userModelDataMapper.transform(usersCollection);
    this.viewListView.renderUserList(userModelsCollection);
  }

/*  private void getUserList() {
    this.getUserListUseCase.execute(new UserListObserver(), null);
  }*/

  private final class UserListObserver extends DefaultObserver<List<Post>> {

    @Override
    public void onComplete() {
      UserListPresenter.this.hideViewLoading();
    }

    @Override
    public void onError(Throwable e) {
      UserListPresenter.this.hideViewLoading();
     // UserListPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
      UserListPresenter.this.showViewRetry();
    }

    @Override
    public void onNext(List<Post> posts) {
      UserListPresenter.this.showUsersCollectionInView(posts);
    }
  }
}
