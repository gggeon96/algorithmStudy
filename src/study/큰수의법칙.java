package study;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int k =K;
        int[] arr= new int[N];
        int sum =0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = N-1; M>0; ) {
            if(k==0){
                k = K;
                sum+=arr[i-1];
                continue;
            }
            sum += arr[i];
            M--;
        }
        System.out.println(sum);
    }
}
