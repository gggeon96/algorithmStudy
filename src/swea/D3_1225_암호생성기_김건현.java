package swea;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기_김건현 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\KIMSTUDY\\input.txt");
        System.setIn(new FileInputStream(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int T = 1; 10 >= T; T++) {
            bw.write("#"+T+" ");
            Queue<Integer> integerQueue = new LinkedList<>();
            br.readLine(); // 테스트 케이스 번호.쓰지않는다
            st = new StringTokenizer(br.readLine());
            int minus = 1;

            //초기화
            for (int i = 0; i < 8; i++) {
                integerQueue.offer(Integer.parseInt(st.nextToken()));
            }

            //0이하의 수가 나올때까지 반복
            while(true){
                int N = integerQueue.poll();
                if(N==0||(N-minus)<=0){//탈출조건. 0을만나면 제일뒤로 보내고 프로그램 종료
                    integerQueue.offer(0);
                    break;
                }
                //수를 점점 증가하는 수로 빼준다
                N -= minus;
                integerQueue.offer(N);
                if(++minus>5){
                    minus = 1;
                }
            }

            //iterator를 이용한 반복
            Iterator<Integer> iterator = integerQueue.iterator();
            while(iterator.hasNext()){
                bw.write(iterator.next()+" ");
            }
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
