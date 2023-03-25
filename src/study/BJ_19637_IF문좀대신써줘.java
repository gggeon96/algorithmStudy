package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_19637_IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        //init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //칭호의 개수
        int M = Integer.parseInt(st.nextToken()); //칭호를 출력해야하는 캐릭터들의 개수
        ArrayList<Tag> tags = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()); //tagName and max
            tags.add(new Tag(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        //이분탐색
        for (int i = 0; i < M; i++) {
            int myPower = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N-1;
            while (left <= right) {
                int mid = (left+right)/2;
                if (tags.get(mid).maxPower < myPower) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            sb.append(tags.get(left).tagName);
            sb.append("\n");
        }

        System.out.println(sb.toString());




    }

}
class Tag{
    String tagName;
    int maxPower;

    public Tag(String tagName, int max) {
        this.tagName = tagName;
        this.maxPower = max;
    }
}
