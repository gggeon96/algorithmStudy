package bj;

import java.util.Scanner;

public class BJ_1244_스위치켜고끄기_김건현 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(); //스위치 길이
        int gender; //성별
        int index; //받은 숫자
        int number;
        int[] lights = new int[size]; //스위치 저장배열
        for (int i = 0; i < size; i++) { //초기화
            lights[i] = sc.nextInt();
        }
        int reps = sc.nextInt(); //받을 학생의 수
        for (int i = 0; i < reps; i++) {
            gender = sc.nextInt();
            number = sc.nextInt();
            index = number -1;
            if(gender==1){ //낭학생의 경우
                // j는 받은숫자부터 배수만큼 바꿔준다. 배열의 size를 넘어가지 않는것이 조건
                for(int j=index;size>j;j+=number){
                    //스위치 상태 반전
                    changeLight(lights, j);
                }
            }else { //여학생의 경우
                //홀수개 number범위가 주어지는데 가운데는 무조건 바뀜
                changeLight(lights,index);
                //좌우로 1씩 뻗어간다. 대신 배열의 범위를 벗어나면 안됨
                for (int j = 1; index + j < size && index - j >= 0; j++) {
                    if (lights[index + j] == lights[index - j]) { //좌우대칭이면 바꿔주기
                        changeLight(lights, index + j);
                        changeLight(lights, index - j);
                    } else { //대칭이 아니면 반복문 종료
                        break;
                    }
                }
            }


        }
        for (int i = 0; i < size; i++) { //출력. 한줄에 20개씩만 출력
            if(i%20 == 0&& i!=0) System.out.println();
            System.out.print(lights[i]+" ");
        }
    }

    //조명 반전
    public static void changeLight(int[] lights, int index) {
        if(lights[index]==1) lights[index] = 0;
        else lights[index] = 1;
    }
}
