//package programmers.lv2;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.stream.IntStream;
//
//class Solution_12899 {
//    public String solution(int n) {
//        String[] arr = {"4", "1", "2"}; // 이 배열의 인덱스 = 나머지 값
//        StringBuilder sb = new StringBuilder();
//
//        while(n > 0) {
//            int index = n % 3;
//            n /= 3;
//
//            if(index == 0) {
//                n--;
//            }
//            sb.insert(0, arr[index]);
//        }
//        int[][] arr2 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,1}};
//
//
//        int[] B = new int[]{5,4,4};
//        Arrays.sort(B, );
//
//        return sb.toString();
//    }
//}
//
//
//public class prog_12899 {
//    public static void main(String[] args) {
//        Solution_12899 solution = new Solution_12899();
//        System.out.println(solution.solution(500));
//    }
//}
