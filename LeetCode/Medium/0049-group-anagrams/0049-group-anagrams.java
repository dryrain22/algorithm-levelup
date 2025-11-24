class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        if (strs.length == 0) return resultList;

        for(int i = 0; i< strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sortStr = Arrays.toString(charArr);

            if(map.containsKey(sortStr)) {
                map.get(sortStr).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortStr, list);
            }
        }
        
        resultList.addAll(map.values());
        return resultList;
    }
}