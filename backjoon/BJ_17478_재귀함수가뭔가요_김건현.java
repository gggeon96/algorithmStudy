package com.kim.backjoon;

import java.util.Scanner;

public class BJ_17478_재귀함수가뭔가요_김건현 {
    static int numberOfUnderBar =0; //출력할 '_'의개수 여기에*4하면 언더바의 개수가 된다.
    public static void whatIs(int n){
        if(n==0){
            System.out.println(printUnderBar(numberOfUnderBar) + "\"재귀함수가 뭔가요?\"");
            System.out.println(printUnderBar(numberOfUnderBar) +"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(printUnderBar(numberOfUnderBar) + "라고 답변하였지.");
            return;
        }
        System.out.println(printUnderBar(numberOfUnderBar) + "\"재귀함수가 뭔가요?\"");
        System.out.println(printUnderBar(numberOfUnderBar)  + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(printUnderBar(numberOfUnderBar)  + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(printUnderBar(numberOfUnderBar)  + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        numberOfUnderBar++;
        whatIs(n-1);
        numberOfUnderBar--;
        System.out.println(printUnderBar(numberOfUnderBar)  +"라고 답변하였지.");
    }
    static String printUnderBar(int rep){ //언더바의 개수 출력하느 함수
        if(rep==0) return "";
        String str = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rep*4;i++){
            sb.append("_");
        }
        str = sb.toString();
        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        whatIs(n);
    }
}
