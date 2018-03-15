package com.example.vgarcama.cleanarchitecturepractice.di.modules;

import com.example.interactor.Login;
import com.example.interactor.UseCase;
import com.example.vgarcama.cleanarchitecturepractice.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;



@Module
public class UserModule {

    public UserModule() {
        //empty constructor
    }

    @Provides
    @PerActivity
    @Named("login")
    UseCase provideLoginUseCase(Login login) {
        return login;
    }

    }
