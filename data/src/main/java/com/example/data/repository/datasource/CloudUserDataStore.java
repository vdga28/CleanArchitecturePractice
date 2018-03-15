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
package com.example.data.repository.datasource;

import com.example.data.cache.UserCache;
import com.example.data.entity.PostsEntity;
import com.example.data.net.ApiClient;
import com.example.data.net.ApiServices.ApiService;
import com.example.data.net.RestApi;


import java.util.List;

import io.reactivex.Observable;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore implements UserDataStore {

  private final RestApi restApi;
  private final UserCache userCache;

  /**
   * Construct a {@link UserDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link ApiClient} implementation to use.
   * @param userCache A {@link UserCache} to cache data retrieved from the api.
   */
  CloudUserDataStore(RestApi restApi, UserCache userCache) {
    this.restApi = restApi;
    this.userCache = userCache;
  }

  @Override
  public Observable<List<PostsEntity>> userEntityList() {
    return (Observable<List<PostsEntity>>) this.restApi.userEntityList();
  }

  @Override
  public Observable<PostsEntity> userEntityDetails(final int userId) {
    //return this.restApi.userEntityById(userId).doOnNext(CloudUserDataStore.this.userCache::put);
    return null;
  }
}
