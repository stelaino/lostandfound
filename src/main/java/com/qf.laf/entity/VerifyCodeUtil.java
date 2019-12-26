package com.qf.laf.entity;

import java.util.Random;

public class VerifyCodeUtil {
    public static String getRandomNumCode(int number) {
        String codeNum = "";
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int next = random.nextInt(10000);//目的是产生足够随机的数，避免产生的数字重复率高的问题
//    			System.out.println(next);
            codeNum += numbers[next % 10];
        }
        System.out.println("--------");
        System.out.println(codeNum);

        return codeNum;
    }

    //测试验证码功能
    public static void main(String[] args) {
        String code = VerifyCodeUtil.getRandomNumCode(10);
        System.out.println(code);
    }
}