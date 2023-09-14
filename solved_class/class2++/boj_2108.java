package solved_class.solved2_plus_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        List<Integer> modeList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        double sum = 0;

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numList.add(num);
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(double num : numList) {
            sum += num;
        }
        int Average = (int) Math.round(sum/N);
        System.out.println(Average);

        Collections.sort(numList);
        System.out.println(Math.round(numList.get(N/2)));

        Collections.sort(new ArrayList<>(map.keySet()), (value1, value2) -> map.get(value1).compareTo(map.get(value2)));
        int max = 0;
        for(int value : map.values()) {
            if(max < value) {
                max = value;
            }
        }

        for(Map.Entry<Integer, Integer> entryset : map.entrySet()) {
            if(entryset.getValue() == max) {
                modeList.add(entryset.getKey());
            }
        }
        if(modeList.size() >= 2) System.out.println(modeList.get(1));
        else System.out.println(modeList.get(0));

        System.out.println(Collections.max(numList)-Collections.min(numList));
    }
}
