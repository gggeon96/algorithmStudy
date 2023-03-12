package com.kim.algoStudy;

import java.io.*;
import java.util.StringTokenizer;

//슬라이딩 윈도우? 투포인터? 암튼그거
public class BJ_21921_블로그 {
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int count; //같은 최대값이 몇개있는지
        int max;
        int[] visitors = new int[N];
        for (int i = 0; i < N; i++) visitors[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < X; i++) sum+= visitors[i];
        max = sum;
        count = 1;

        for (int i = X; i < N; i++) {
            sum-=visitors[i-X];
            sum+=visitors[i];
            if(sum>max) {
                max = sum;
                count = 1;
            }
            else if(sum==max) count++;
        }

        bw.write(max==0?"SAD":(max+"\n"+count));
        bw.flush();
        bw.close();
        br.close();



    }
}
