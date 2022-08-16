package com.kim.backjoon;

import java.util.Scanner;

public class BJ_2839_설탕배달_김건현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min= Integer.MAX_VALUE;
        int tmp=0;
        int coin=0;
        int five = n/5;
        for(int i=five;i>=0;i--) {
            coin= i;
            tmp = n;
            tmp -= 5*i;
            if(tmp%3 != 0) continue;
            else {
                coin += tmp/3;
            }
            min = Math.min(min, coin);
        }
        if(min==Integer.MAX_VALUE) System.out.println(String.valueOf(-1));
        else System.out.println(String.valueOf(min));







    }
}
