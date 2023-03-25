package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15961_회전초밥_김건현 {

    static int n, d, k, c;
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new int[d + 1];

        System.out.println(slide());
    }

    static int slide() {
        int inSlide = 0, chance;
        // 일단 처음 k개의 슬라이드에 담기
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0) {
                inSlide++;
            }
            visited[arr[i]]++;
        }
        chance = inSlide;
        for (int i = 1; i < n; i++) {
            if (chance <= inSlide) {
                if (visited[c] == 0) {
                    chance = inSlide + 1;
                } else {
                    chance = inSlide;
                }
            }
            // 슬라이드 이동 시, 앞쪽 스시는 못먹게 되고, 한번도 먹은적이 없다면 슬라이드 내에서 먹은 스시 개수 -1
            visited[arr[i - 1]]--;
            if (visited[arr[i - 1]] == 0) {
                inSlide--;
            }
            // 슬라이드 이동 시, 뒤쪽 스시 먹게 되고, 한번도 먹은적 없다면 슬라이드 내에서 먹은 스시 개수 +1
            // 회전초밥은 회전하므로 % n 을 사용해야한다
            if (visited[arr[(i + k - 1) % n]] == 0) {
                inSlide++;
            }
            visited[arr[(i + k - 1) % n]]++;
        }
        return chance;
    }
}
