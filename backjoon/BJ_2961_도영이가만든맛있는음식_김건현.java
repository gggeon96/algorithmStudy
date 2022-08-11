package com.kim.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식_김건현 {
    static int MIN = Integer.MAX_VALUE;
    static boolean[] visited;
    static Food[] foods;
    static int i = 1;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        foods = new Food[N];// 신맛과 쓴맛을 저장하는 food배열 생성.
        for (int i = 0; i < N; i++) { //초기화
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            foods[i] = new Food(S, B);
        }
        cook(1,foods[0].S,foods[0].B,1); //넣고
        cook(1,0,0,0); //안넣고
        System.out.print(MIN);

    }

    /**
     *
     * @param count 이떄까지 고려한 재료의 개수.(넣었든 안넣었든)
     * @param sumS S의 곱들
     * @param sumB B의 합들
     * @param length 최소 한개는 넣어야하니 실제로 넣은 재료의 개수
     */
    static void cook(int count,int sumS,int sumB, int length){
        if((Math.abs(sumB-sumS)) < MIN&&length!=0) MIN = Math.abs(sumB-sumS); //최소값 결정
        if(count==N) return;
        cook(count+1,sumS,sumB,length); //
        if(sumS ==0) sumS = foods[count].S;
        else sumS *= foods[count].S;
        sumB += foods[count].B;
        cook(count+1,sumS,sumB,length+1);
    }
    static class Food{
        int S;
        int B;

        public Food(int s, int b) {
            S = s;
            B = b;
        }
    }

}
