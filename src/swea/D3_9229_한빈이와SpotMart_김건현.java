package swea;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart_김건현 {
    static int M;
    static int N;
    static int[] weight;
    static int max = 0;
    //dfs통해풀기
    static void dfs(int idx, int count,int value){
        //주어진 제한을 넘기면 리턴
        if(value>M) return;
        //2개의 봉지를 집으면 max인지확인
        if(count == 2) {
            if(value>max) max = value;
            return;
        }
        //인덱스를 넘어가면 리턴(2개를 안집었을 때)
        if(idx==N) return;
        dfs(idx+1,count+1,value+weight[idx]);
        dfs(idx+1,count,value);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int T = 1; TC >= T; T++) {
            max = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            weight = new int[N];
            st = new StringTokenizer(br.readLine());
            //N개의 배열에 과자의 무게 넣기
            for (int i = 0; i < N; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0, 0);
            bw.write("#"+T+" "+max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
