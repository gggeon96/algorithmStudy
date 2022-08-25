package com.kim.algoStudy;

import java.util.Scanner;

public class BJ_1439_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[2];
        String str = sc.next();

        count[str.charAt(0) - '0']++; //제일 첫번쨰 요소 count++
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) { //다른 숫자가 나오면 count++
                count[str.charAt(i) - '0']++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}


class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] count = new int[2];
        String str = sc.next();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                count[str.charAt(i - 1) - '0']++;
            }
        }
        if (str.charAt(str.length() - 1) != str.charAt(str.length() - 2)) count[str.charAt(str.length() - 1) - '0']++;
        System.out.println(Math.min(count[0], count[1]));
    }
}
