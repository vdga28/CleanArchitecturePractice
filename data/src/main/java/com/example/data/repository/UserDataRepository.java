/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.data.repository;


import com.example.Post;
import com.example.data.entity.mapper.PostEntityDataMapper;
import com.example.data.repository.datasource.UserDataStore;
import com.example.data.repository.datasource.UserDataStoreFactory;
import com.example.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements PostRepository {
  @Override
  public Observable<List<Post>> posts() {
    return null;
  }

  @Override
  public Observable<Post> user(int postId) {
    return null;
  }

/*  private final UserDataStoreFactory userDataStoreFactory;
  private final PostEntityDataMapper userEntityDataMapper;

  @Inject
  UserDataRepository(UserDataStoreFactory dataStoreFactory,
      PostModelDataMapper userEntityDataMapper) {
    this.userDataStoreFactory = dataStoreFactory;
    this.userEntityDataMapper = userEntityDataMapper;
  }

  @Override
  public Observable<List<Post>> posts() {
    //we always get all users from the cloud
    final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
    return userDataStore.userEntityList().map(this.userEntityDataMapper::transform);
  }

  @Override
  public Observable<Post> user(int userId) {
    final UserDataStore userDataStore = this.userDataStoreFactory.create(userId);
    return userDataStore.userEntityDetails(userId).map(this.userEntityDataMapper::transform);
  }*/
}
