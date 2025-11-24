class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new ArrayList<>();

        int lenS = s.length();
        int lenP = p.length();
        int[] map = new int[26];

        for (int i = 0; i < lenP; i++) {
            map[p.charAt(i) - 'a']++;
        }

        int start = 0;
        for (int i = 0; i < lenS; i++) {
            map[s.charAt(i) - 'a']--;

            // 원상복구
            if (lenP <= i + start){
                map[s.charAt(start) - 'a']++;
                start++;
            }

            if (isAllZero(map)){
                resultList.add(start);
            }

        }
        return resultList;
    }

    private boolean isAllZero(int[] map){
        return Arrays.stream(map).allMatch(m -> m == 0);
    }
}