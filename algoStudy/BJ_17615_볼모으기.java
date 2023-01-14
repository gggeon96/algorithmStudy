package com.kim.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17615_볼모으기 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[] balls = br.readLine().toCharArray();
        int a,b;
//        System.out.println("#target Is Blue");
        a = find(balls.clone(), 'B');

//        System.out.println("#target Is Red");
        b = find(balls.clone(), 'R');

        int ans = Math.min(a, b);
        System.out.println(ans);
    }

    public static int find(char[] balls,char target) {
        char[] clone = balls.clone();
        char anotherColor = (target=='B'?'R':'B');
        int targetIndex;
        int countA = 0;
        int countB = 0;
        targetIndex = findTarget(balls,true,target);
//        System.out.println("tartgetIdx left: "+targetIndex);
        for (int i = 0; i < N; i++) {
            if (balls[i] != target && targetIndex != -1&& targetIndex<i) {
                balls[i] = target;
                balls[targetIndex] = anotherColor;
                targetIndex++;
                countA++;
            }
        }

        balls = clone;

        targetIndex = findTarget(balls,false,target);
//        System.out.println("tartgetIdx right: "+targetIndex);
        for (int i = N - 1; i >= 0; i--) {
            if (balls[i] == anotherColor && targetIndex != -1&& targetIndex>i) {
                balls[i] = target;
                balls[targetIndex] = anotherColor;
                targetIndex--;
                countB++;
            }
        }
//        System.out.println("countA: "+countA+"/ countB: "+countB);
        int ans = Math.min(countA, countB);
        return ans;
    }



    private static int findTarget(char[] balls, boolean isFromLeft,char target) {
        int targetIndex = -1;
        if (isFromLeft) {
            for (int i = 0; i < N; i++) {
                if (balls[i] == target) {
                    targetIndex = i;
                    break;
                }
            }
        } else {
            for (int i = N - 1; i >= 0; i--) {
                if (balls[i] == target) {
                    targetIndex = i;
                    break;
                }
            }
        }


        return targetIndex;
    }


}

