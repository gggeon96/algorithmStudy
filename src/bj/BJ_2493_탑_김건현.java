package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑_김건현 {

    static class Tower{
        public int height;
        public int index;

        public Tower() {}
        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tower[] towers = new Tower[N+1];
        int[] hit = new int[N+1];
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //초기화. tower객체를 만들어 인덱스와 높이를 저장해둔다.
        for (int i = 1; N >= i; i++) {
            towers[i] = new Tower(Integer.parseInt(st.nextToken()), i);
        }

        //스택은 아래로 내려갈 수록 높이가 높은 기둥이 자동으로 쌓이게 된다.
        for(int i=N;i>0;i--){
            Tower tower1 = towers[i]; //비교할 기둥
            if(stack.isEmpty()||tower1.height<stack.peek().height){ //top에 있는 기둥보다 낮은 기둥이라면 스택에 push해준다.
                stack.push(tower1); //뒤쪽기둥중에 레이저가 닿을 기둥이 없으니 스택에 넣어주고 continue
                continue;
            }
            while(!stack.isEmpty()&&tower1.height>=stack.peek().height){ //기둥에 레이저가 닿는다면. 스택에서 자기보다 큰 기둥을 만날때까지 반복
                Tower tmp = stack.pop();
                hit[tmp.index] = tower1.index;
            }
            stack.push(tower1);

        }

        //출력
        for(int i=1;i<=N;i++){
            System.out.print(hit[i]+" ");
        }


    }
}
