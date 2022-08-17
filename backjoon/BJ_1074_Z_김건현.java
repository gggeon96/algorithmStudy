package com.kim.backjoon;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z_김건현 {
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        where(N, r, c, 0);
        System.out.println(ans);

    }

    static void where(int N, int r, int c, int count) {
        if (N == 1) {
            if (r == 0 && c == 0) {
                ans = count;
            } else if (r == 0 && c == 1) {
                ans = count + 1;
            } else if (r == 1 && c == 0) {
                ans = count + 2;
            } else {
                ans = count + 3;
            }
            return;
        }

        double result = Math.pow(2, N);//8
        int num = (int) (result / 2);//4
        int idx = num * num;//16
        if (num > r && num > c) {//왼쪽위
            where(N - 1, r, c, count);
        } else if (num > r && num <= c) { //오른쪽 위
            where(N - 1, r, c - num, count + idx);
        } else if (num <= r && num > c) { //왼 아래
            where(N - 1, r - num, c, count + idx * 2);
        } else { //오른쪽 아래
            where(N - 1, r - num, c - num, count + idx * 3);
        }


    }


}
