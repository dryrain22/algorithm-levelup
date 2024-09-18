package solved_class.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_11279 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(maxHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(maxHeap.remove());
				}
			}
			maxHeap.add(x);
		}
	}
}
