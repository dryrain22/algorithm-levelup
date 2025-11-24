class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(Arrays.asList(1));  

        for (int i = 1; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);

            for (int j = 1; j < i; j++) {
                int num = answer.get(i-1).get(j-1) + answer.get(i-1).get(j);
                tmp.add(num);
            }

            tmp.add(1);
            answer.add(tmp);
        }

        return answer;
    }
}