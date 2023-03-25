package bj;

import java.io.*;

public class BJ_2581_소수_김건현 {
    static boolean isItPrime(int n){
        if(n==1) return false;
        else if(n==2) return true;
        else{
            for(int i=2;i<n;i++){
                if(n%i==0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 0;
        for (int i = N; i >= M; i--) {
            if(isItPrime(i)){
                sum += i;
                min = i;
            }
        }
        if(sum ==0) {
            bw.write("-1");
        }else{
            bw.write(sum+"\n"+min);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
