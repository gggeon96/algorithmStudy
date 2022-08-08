package com.kim.backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_카드2_김건현 {
    public static void main(String[] args) {
        Queue<Integer> cards = new LinkedList<>();
        Scanner sc = new Scanner(System.in); //입력은 하나만 받으니 Scanner를 써도 속도차이 크게 X
        int N = sc.nextInt(); //1부터 N까지의 카드
        for (int i = 1; i <= N; i++) { //N장의 카드를 큐에 초기화
            cards.offer(i);
        }
        while(cards.size()!=1){ //한장만 남을때 까지 반복. 만약 한장만 있으면 아래 반복문이 실행안된다.
            cards.poll(); //한장을 빼고
            int secondCard = cards.poll(); //나머지한장은 빼서 큐의 제일 뒤로 넣기
            cards.offer(secondCard);
        }
        System.out.print(cards.poll());
    }
}
