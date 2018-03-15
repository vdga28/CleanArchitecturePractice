/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.example.vgarcama.cleanarchitecturepractice;

import com.example.vgarcama.cleanarchitecturepractice.view.model.PostsModel;

import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link PostsModel}.
 */
public interface PostListView extends LoadDataView {
  /**
   * Render a user list in the UI.
   *
   * @param userModelCollection The collection of {@link PostsModel} that will be shown.
   */
  void renderUserList(Collection<PostsModel> userModelCollection);

  /**
   * View a {@link PostsModel} profile/details.
   *
   * @param postsModel The user that will be shown.
   */
  void viewUser(PostsModel postsModel);
}
