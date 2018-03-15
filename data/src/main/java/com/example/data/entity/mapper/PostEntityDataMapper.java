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
package com.example.data.entity.mapper;


import com.example.Post;
import com.example.data.entity.PostsEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link PostsEntity} (in the data layer) to {@link Post} in the
 * domain layer.
 */
@Singleton
public class PostEntityDataMapper {

  @Inject
  PostEntityDataMapper() {}

  /**
   * Transform a {@link PostsEntity} into an {@link Post}.
   *
   * @param postEntity Object to be transformed.
   * @return {@link Post} if valid {@link PostsEntity} otherwise null.
   */
  public Post transform(PostsEntity postEntity) {
    Post post = null;
    if (postEntity != null) {
      post = new Post(postEntity.getId());
      post.setTitle(post.getTitle());
    }
    return post;
  }

  /**
   * Transform a List of {@link PostsEntity} into a Collection of {@link Post}.
   *
   * @param postEntityCollection Object Collection to be transformed.
   * @return {@link Post} if valid {@link PostsEntity} otherwise null.
   */
  public List<Post> transform(Collection<PostsEntity> postEntityCollection) {
    final List<Post> userList = new ArrayList<>(20);
    for (PostsEntity userEntity : postEntityCollection) {
      final Post user = transform(userEntity);
      if (user != null) {
        userList.add(user);
      }
    }
    return userList;
  }
}
