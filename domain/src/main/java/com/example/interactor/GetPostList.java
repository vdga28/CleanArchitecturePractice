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
package com.example.interactor;


import com.example.Post;
import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.PostRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link Post}.
 */
public class GetPostList extends UseCase<List<Post>, Void> {

  private final PostRepository postRepository;

  @Inject
  GetPostList(PostRepository postRepository, ThreadExecutor threadExecutor,
              PostExecutionThread postExecutionThread) {
    super(threadExecutor, postExecutionThread);
    this.postRepository = postRepository;
  }

  @Override
  Observable<List<Post>> buildUseCaseObservable(Void unused) {
    return this.postRepository.posts();
  }
}
