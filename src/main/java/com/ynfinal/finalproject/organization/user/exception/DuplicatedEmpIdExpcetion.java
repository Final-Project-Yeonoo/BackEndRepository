package com.ynfinal.finalproject.organization.user.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DuplicatedEmpIdExpcetion extends RuntimeException{


    public DuplicatedEmpIdExpcetion(String message) {
        super(message);
    }
}
