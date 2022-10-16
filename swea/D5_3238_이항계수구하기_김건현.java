package com.kim.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_3238_이항계수구하기_김건현 {

    static int T, p;
    static long N, R;
    static long result;
    static long[] factorial;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            R = Long.parseLong(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            factorial = new long[(int)N+1];
            factorial[0]=1;
            for (int i = 1; i <= N; i++) {
                factorial[i] = factorial[i-1] *i;
                factorial[i] %= p;
            }

            long a = factorial[(int)N];
            long b = (factorial[(int)R]*factorial[(int)(N-R)])%p;
            result = calculatePow(b,p-2);

            result = (result *a)%p;
            sb.append("#").append(t).append(" ").append(result);
            System.out.println(sb.toString());
        }
    }

    static long calculatePow(long a, long b) {
        if( b==0 )return 1;  // 0이면 1
        else if( b==1 ) return a; // a그대로 리턴

        if(b%2==0) {  //짝수면 거듭제곱을 두개로 나눠서 제곱한 뒤 곱함
            long temp = calculatePow(a,b/2);
            return (temp*temp)%p;
        }
        //지수-1 a한번곱하기
        long temp = calculatePow(a, b-1)%p;
        return (temp*a)%p;
    }
}
