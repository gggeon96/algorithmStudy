package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.StringTokenizer;


public class BJ_1697_숨바꼭질_김건현 {





    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[100001];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        //BFS. 목적지를 찾을 때 까지
        while(!q.isEmpty()) {
            int j=q.size();
            for(int i=0;i<j;i++) {
                int tmp = q.poll();

                //목적지라면 cnt출력하고 종료
                if(tmp==k) {
                    bw.write(String.valueOf(cnt));
                    bw.flush();
                    bw.close();
                    return;
                }
                //아니라면 현재 3방향으로 분기. 이미 가본 곳이라면 가지않기. BFS이니 너비우선 탐색이라 가능
                if(tmp+1<=100000&&check[tmp+1]==false) {
                    check[tmp+1] = true;
                    q.offer(tmp+1);
                }
                if(tmp-1>=0&&check[tmp-1]==false) {
                    check[tmp-1] = true;
                    q.offer(tmp-1);
                }
                if(tmp*2<=100000&&check[tmp*2]==false) {
                    check[tmp*2] = true;
                    q.offer(tmp*2);
                }
            }
            cnt++;
        }
        bw.flush();
        bw.close();
    }
}