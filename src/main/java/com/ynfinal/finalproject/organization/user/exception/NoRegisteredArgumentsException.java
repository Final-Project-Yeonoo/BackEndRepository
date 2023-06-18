package com.ynfinal.finalproject.organization.user.exception;

public class NoRegisteredArgumentsException
        extends RuntimeException{

    // 기본 생성자 + 에러메시지를 받는 생성자
    public NoRegisteredArgumentsException(String message) {
        super(message);
    }
}
