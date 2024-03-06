package labg_study;

import java.util.Arrays;

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

public class pgs_176963 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5,10,1,3}, 
				new String[][] {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}})));
	}
}
