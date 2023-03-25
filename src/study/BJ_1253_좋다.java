package study;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시도1. 정렬하고 그거보다 작은수들 부분집합 탐색해보기 - 시간초과삘, N은 정수니까 큰수와 합쳐도 나옴. 틀린방법
시도2. 두 개만 합치면 되니까 투포인터로? ->
 */
public class BJ_1253_좋다 {
    static int N;
    static int[] input;
    static int goodCount =0;
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);

        //logic
        for (int i = 0; i < N; i++) {
            int target = input[i];
            int start = 0, end = N-1;
            while (start < end) {
                int sum = input[start]+input[end];
                if(sum==target){
                    if (start != i && end != i) { //target과 다른수인지 체크
                        goodCount++;
                        break;
                    }
                    else if(start==i) //target과 다른수인가
                        start++;
                    else
                        end--; //target과 다른수인가
                }else if(sum<target) start++; //수 늘려주기
                else
                    end--; //수 줄여주기
            }
        }
        bw.write(String.valueOf(goodCount));
        bw.flush();
        bw.close();
        br.close();
    }
}
