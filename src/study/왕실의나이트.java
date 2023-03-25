package study;

import java.util.Scanner;

public class 왕실의나이트 {
    public static void main(String[] args) {
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
        Scanner sc = new Scanner(System.in);
        String point = sc.next();
        int col = point.charAt(0)-'a'; //a2 0
        int row = point.charAt(1)-'1'; //
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (row + dy[i] >= 0 && col + dx[i] >= 0 && row + dy[i] < 8 && col + dx[i] < 8) {
                count++;
            }
        }
        System.out.println(count);
    }
}
