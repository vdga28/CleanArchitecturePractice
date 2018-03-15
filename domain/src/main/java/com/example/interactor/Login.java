package com.example.interactor;

import com.example.executor.PostExecutionThread;
import com.example.executor.ThreadExecutor;
import com.example.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;


public class Login extends UseCase {

    private final UserRepository userRepository;
    private String email;
    private String password;
    private int type;
    private String deviceToken;

    @Inject
    protected Login(UserRepository userRepository,
                    ThreadExecutor threadExecutor,
                    PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    public void bindParams(String email, String password, int type, String deviceToken) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.deviceToken = deviceToken;
    }

    @Override
    Observable buildUseCaseObservable(Object o) {
        return this.userRepository.login(email, password, type, deviceToken);
    }
}
