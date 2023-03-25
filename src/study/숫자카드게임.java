package study;

import java.util.Scanner;

public class 숫자카드게임 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = Integer.MIN_VALUE;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int tmp = sc.nextInt();
                if(tmp<min) min = tmp;
            }
            if(min>ans) ans = min; // 작은 수 중에 젤 큰수찾기
        }
        System.out.println(ans);
    }

}
