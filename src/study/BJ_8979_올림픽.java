package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        ArrayList<Country> countries = new ArrayList<>();
        Country targetCountry = new Country();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int countryId = Integer.parseInt(st.nextToken());
            int goldMedal = Integer.parseInt(st.nextToken());
            int silverMedal = Integer.parseInt(st.nextToken());
            int bronzeMedal = Integer.parseInt(st.nextToken());
            countries.add(new Country(countryId, goldMedal, silverMedal, bronzeMedal));
            if (countryId == K) {
                targetCountry.countryId = countryId;
                targetCountry.goldMedal = goldMedal;
                targetCountry.silverMedal = silverMedal;
                targetCountry.bronzeMedal = bronzeMedal;
            }
        }
        for (int i = 0; i < N; i++) {
            if(targetCountry.compareTo(countries.get(i))>0) count++;
        }

        System.out.println(count+1);


    }

}

class Country implements Comparable<Country>{
    public int countryId;
    public int goldMedal;
    public int silverMedal;
    public int bronzeMedal;

    public Country(int countryId, int goldMedal, int silverMedal, int bronzeMedal) {
        this.countryId = countryId;
        this.goldMedal = goldMedal;
        this.silverMedal = silverMedal;
        this.bronzeMedal = bronzeMedal;
    }

    public Country() {
    }

    @Override
    public int compareTo(Country o) {
        if (o.goldMedal == this.goldMedal) {
            if (o.silverMedal == this.silverMedal) {
                if (o.bronzeMedal == this.bronzeMedal) {
                    return 0;
                }
                return o.bronzeMedal - this.bronzeMedal;
            }
            return o.silverMedal - this.silverMedal;
        }
        return (o.goldMedal - this.goldMedal);
    }
}
