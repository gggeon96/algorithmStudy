package swea;

import java.util.Scanner;

public class D3_1289_원재의메모리복구하기_김건현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int count = 0; //출력할 정답
        for (int i = 1; T >= i; i++) {
            String memory = sc.next(); //문자열로 읽어들인다
            int[] arr = new int[memory.length()];
            for(int j=0;j<memory.length();j++) //초기화
                arr[j] = memory.charAt(j)-'0';

            count = arr[0]; //0이면 수정횟수 필요없고 1이면 수정횟수 1로 시작

            for (int j = 1; j < arr.length; j++) {
                if(arr[j] != arr[j-1]) //이전것과 다르면 수정횟수 +1
                    count++;
            }
            System.out.println("#"+i+" "+count);
        }
    }
}
