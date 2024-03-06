package labg_study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
    	int[] answer = new int[photo.length];
    	
    	for(int i = 0; i < name.length; i++) {
    		int start = 0;
    		
    		for(String[] p : photo) {
    			if(Arrays.stream(p).anyMatch(name[i]::equals)) {
    				answer[start] += yearning[i];
    			}
    			start++;
    		}
    	}
    	
        return answer;
    }
}

// BFS 풀이
class Solution2 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {

		int[] answer = new int[photo.length];
		Queue<Node> queue = new LinkedList<>();

		for(int i = 0; i < name.length; i++) {
			queue.offer(new Node(name[i], i));
		}

		while(!queue.isEmpty()) {
			int idx = 0;
			Node node = queue.poll();

			for(String[] arr_p : photo) {
				for(String p : arr_p) {
					if(p.equals(node.name)) {
						answer[idx] += yearning[node.i];
						break;
					}
				}
				idx++;
			}
		}

		return answer;
	}
}

class Node {
	String name;
	int i;

	public Node(String name, int i) {
		this.name = name;
		this.i = i;
	}
}

public class pgs_176963 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		System.out.println(Arrays.toString(solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5,10,1,3}, 
				new String[][] {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}})));
	}
}
