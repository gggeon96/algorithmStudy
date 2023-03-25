package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2239_스도쿠_김건현 {
    static int[][] arr =new int[9][9];
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //input
        for(int i=0;i<9;i++) {
            char[] c = br.readLine().toCharArray();
            for(int j=0;j<9;j++) {
                arr[i][j] = c[j]-'0';
            }
        }

        dfs(0);

        //출력
        for(int[] a : arr) {
            for(int b : a) {
                sb.append(b);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int d) {
        //종료조건
        if(d==81) {
            flag = true;
            return;
        }

        int row = d/9;
        int col = d%9;

        if(arr[row][col]!=0)
            dfs(d+1);
        else {
            for(int i=1;i<10;i++) {
                if(!isValid(row,col,i))continue;
                arr[row][col] = i;
                dfs(d+1);

                // 종료 조건이 아니라면 더이상 선택할 수가 없다는 뜻

                if(flag) return;
                arr[row][col]=0;

            }
        }



    }
    private static boolean isValid(int r, int c, int n) {

        for(int i=0;i<9;i++) {
            if(arr[i][c]==n || arr[r][i]==n) return false;
        }

        int sr = r/3 * 3;
        int sc = c - c%3;
        for(int row=sr;row<sr+3;row++) {
            for(int col=sc;col<sc+3;col++) {
                if(arr[row][col]==n) return false;
            }
        }


        return true;

    }
}
