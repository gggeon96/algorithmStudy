package bj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기_김건현 {
    static int L;
    static int C;
    static char[] arr;
    static char[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        ans = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,0);
        br.close();
    }


    static void dfs(int count, int index) {
        //종료조건.
        if (count == L) {
            if(check(ans)){
                System.out.println(ans);
            }
            return;
        }

        for (int i = index; i < C; i++) {
                //고르기
                ans[count] = arr[i];
                dfs(count+1,i+1);
        }
    }

    static boolean check(char[] ans){
        int aCount=0;
        int bCount=0;
        for(char c:ans){
            if(c=='a'||c=='i'||c=='o'||c=='e'||c=='u') aCount++;
            else bCount++;
        }
        if(aCount>=1&&bCount>=2) return true;
        return false;
    }
}
