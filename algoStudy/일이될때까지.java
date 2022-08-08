package com.kim.algoStudy;

import java.util.Scanner;

public class 일이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int count = 0;
        while(N>1){
            count++;
            if(N%K == 0) {
                N/=K;
                continue;
            }
            N--;
        }
        System.out.println(count);
    }
}
