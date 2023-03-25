package bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_2023_신기한소수_김건현 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); //어차피 수하나만 받으니 Scanner를 써도 괜찮을 것 같다. 절대 BufferedReader가 귀찮은게 아니다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int MAX = 1; //자리수
        if(N==1) {
            bw.write(2+"\n"+3+"\n"+5+"\n"+7);
        }else{
            //각 자리수
            for(int i=0;i<N;i++) MAX*=10;
            int div = MAX/10;


            for (int i = (MAX / 10); MAX > i; i++) { //N=3이면 K=1000. i = 100~ 999까지 div = 100
                div = MAX/10;
                //젤 앞자리수 검사. 2, 3, 5, 7로 시작해야함
                int front = (i/div); //제일 왼쪽 한자리수
                //제일 왼쪽 수가 2,3,5,7로 시작한다면
                if(front==2||front==3||front==5||front==7){
                    div/=10;
                    while(div != 0){
                        if((i/div)==1||(i/div)==3||(i/div)==7||(i/div)==9) {
                            if(!isItPrime(i/div)) break;
                            if(div == 1) {
                                if(isItPrime(i/div)){
                                    bw.write(i+"\n");
                                }
                            }
                            div*=10;
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        sc.close();

    }
    //소수인지 판별
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
}
