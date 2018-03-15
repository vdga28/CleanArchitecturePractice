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
package com.example.vgarcama.cleanarchitecturepractice.mapper;


import com.example.Post;
import com.example.vgarcama.cleanarchitecturepractice.di.PerActivity;
import com.example.vgarcama.cleanarchitecturepractice.view.model.PostsModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform {@link Post} (in the domain layer) to {@link PostsModel} in the
 * presentation layer.
 */
@PerActivity
public class PostModelDataMapper {

  @Inject
  public PostModelDataMapper() {}

  /**
   * Transform a {@link Post} into an {@link PostsModel}.
   *
   * @param post Object to be transformed.
   * @return {@link PostsModel}.
   */
  public PostsModel transform(Post post) {
    if (post == null) {
      throw new IllegalArgumentException("Cannot transform a null value");
    }
    final PostsModel postsModel = new PostsModel(post.getId());
    postsModel.setBody(post.getBody());
    postsModel.setTitle(post.getTitle());
    postsModel.setUserId(post.getUserId());

    return postsModel;
  }

  /**
   * Transform a Collection of {@link Post} into a Collection of {@link PostsModel}.
   *
   * @param postsCollection Objects to be transformed.
   * @return List of {@link PostsModel}.
   */
  public Collection<PostsModel> transform(Collection<Post> postsCollection) {
    Collection<PostsModel> userModelsCollection;

    if (postsCollection != null && !postsCollection.isEmpty()) {
      userModelsCollection = new ArrayList<>();
      for (Post post : postsCollection) {
        userModelsCollection.add(transform(post));
      }
    } else {
      userModelsCollection = Collections.emptyList();
    }

    return userModelsCollection;
  }
}
