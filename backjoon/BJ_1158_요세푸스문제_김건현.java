package com.kim.backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1158_요세푸스문제_김건현 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");
        ArrayList<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        int K = sc.nextInt();
        int idx = 0;
        for (int i = 1; i <= N; i++) { //1부터 N으로초기화
            list.add(i);
        }
        while(list.size()>1){ //1개남을 떄 까지 반복
            idx+= K-1;
            idx = idx%list.size(); //원이니까 인덱스 넘어가지않게 size로 %연산
            //if(list.size<K)
            bw.write(list.remove(idx)+", ");
        }
        bw.write(list.remove(0)+">");
        bw.flush();
        bw.close();
    }
}
