package bj;

import java.util.Scanner;

public class BJ_3040_백설공주와일곱난쟁이_김건현 {
    static boolean[] visited = new boolean[9];
    static int[] dwarfs = new int[9];
    static int[] ans = new int[7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //입력이 9개 고정이니까 스캐너 써도 큰차이 없을 것..
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }
        dfs(0, 0);
        for(int x:ans) System.out.println(x);

    }

    /**
     *
     * @param count 총 선택한 난쟁이 수
     * @param sum   난쟁이숫자의 합
     */
    static void dfs(int count,  int sum) {
        if(count==7){ //7마리를 뽑으면 100이 되는지 확인
            if(sum==100){
                for (int i = 0,idx =0; i < 9; i++) {
                    if(visited[i]) ans[idx++] = dwarfs[i];
                }

            }
        }
        if(sum>100) return;
        for (int i = 0; i < 9; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(count+1,sum+dwarfs[i]);
                visited[i] = false;
            }
        }
        return;
    }
}
