package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO_1828_냉장고_김건현 {

        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                int count = 1;
                Stuff[] stuffs = new Stuff[N];
                //배열 초기화
                for (int i = 0; i < N; i++) {
                        StringTokenizer st = new StringTokenizer(br.readLine());
                        stuffs[i] = new Stuff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                }
                //min순으로 정렬
                Arrays.sort(stuffs);
//                System.out.println("==========정렬된 배열 ==========");
//                for (int i = 0; i < N; i++) {
//                        System.out.println(stuffs[i].min+" / "+stuffs[i].max);
//                }

//                System.out.println("==========정렬된 배열 ==========");
                int standard = stuffs[0].max;//기준이 되는 온도
                for (int i = 1; i < N; i++) {
                        if(standard>=stuffs[i].min)continue; //들어가면 냉장고 새로 할 필요없음
                        //아니면 새로운 냉장고 생성
                        count++;
                        standard = stuffs[i].max;
//                        System.out.println("New 냉장고-> "+stuffs[i].min+" / "+stuffs[i].max);
                }
                System.out.println(count);

        }

        static class Stuff implements Comparable<Stuff>{
                int min;
                int max;

                public Stuff(int min, int max) {
                        this.min = min;
                        this.max = max;
                }

                @Override
                public int compareTo(Stuff o) {
                        if(max==o.max){
                                return min-o.min;
                        }
                        return this.max-o.max;
                }
        }

}
