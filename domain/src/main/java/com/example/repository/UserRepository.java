package com.example.repository;


import com.example.model.User;

import io.reactivex.Observable;

public interface UserRepository {

    Observable<User> login(String email, String password, int types, String deviceToken);

}
