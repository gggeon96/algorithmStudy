package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1978_소수찾기_김건현 {
    static boolean isItPrime(int n){
        if(n==1) return false;
        else if(n==2) return true;
        else{
            for(int i=2;i<n;i++){
                if(n%i==0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if(isItPrime(Integer.parseInt(st.nextToken()))) count++;
        }
        System.out.print(count);
    }
}
