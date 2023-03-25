package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_8458_원점으로집합_김건현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int rest = -1; //나머지
            int maxDis = Integer.MIN_VALUE;
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                //맨해튼거리
                int dis = Math.abs(x)+Math.abs(y);
                //처음에 나머지초기화
                if (i==0){
                    rest = dis%2; //홀짝 판단
                    maxDis = dis;
                }
                if(rest!=dis%2){
                    flag = false; //답을 못구하는 상황
                }
                else{
                    maxDis = Math.max(maxDis,dis);
                }

            }
            int ans = 0;
            if(!flag){
                ans = -1;
            }else{
                //0혹은 음수가 될 때까지
                while(maxDis>0){
                    ans++;
                    maxDis-=ans;
                }
                maxDis *= -1; //양수로
                if(maxDis%2==1){ //홀수칸 남는다면 -> 왔다갔다해야함 -> ans값에 따라 바뀜
                    //한번 더 가야하는상황
                    if(ans%2==0){
                        ans++;
                    }
                    //두번 더 가야하는 상황
                    else{
                        ans+=2;
                    }
                }
            }
            System.out.println("#"+t+" "+ans);
        }

    }
}
