package com.ynfinal.finalproject.util;

public class Utility {

    /**
     * 일련번호를 입력하면 0000xx 형식으로 반환
     * @param no 일련번호
     * @return 0000xx 형식으로 반환
     */
    public static String convertSerial(int no){
        return String.format("%06d", no);
    }
}
