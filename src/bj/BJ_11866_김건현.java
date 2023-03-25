package bj;

import java.util.LinkedList;
import java.util.Scanner;
//요세푸스 문제는 다음과 같다.
//        1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//        이제 순서대로 K번째 사람을 제거한다.
//        한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
//        이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
//        원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
//        예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
//
//        N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
public class BJ_11866_김건현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //N명의사람
        int K = sc.nextInt(); //K번째 사람을 매번 제거
        LinkedList<Integer> list = new LinkedList<>(); //연결리스트에 저장
        int index = 0; //제거할 인덱스
        //초기화
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        //리스트가 빌때까지 반복복
        System.out.print("<"); //결과창 시작
        while(true){ //list가 빌 때까지 무한반복
            index = (index+(K-1))%list.size(); //제거할 대상 선택. N으로 나눠주면 원인것 처럼 접근가능
            System.out.print(list.remove(index)); //출력
            if(list.isEmpty()) //무한루프 탈출 조건
                break;
            System.out.print(", ");
        }
        System.out.print(">");
        sc.close();
    }
}
