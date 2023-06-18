package com.ynfinal.finalproject.global;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {
    private String code;
    private String message;
}
