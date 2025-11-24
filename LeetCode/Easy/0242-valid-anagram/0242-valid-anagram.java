class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // for (int i = 0; i < s.length(); i++) {
        //     String str = String.valueOf(s.charAt(i));

        //     if (t.contains(str)) {
        //         t = t.replaceFirst(str, "");
        //     } else {
        //         return false;
        //     }
        // }

        // return t.equals("");

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(alphabet).allMatch(alpha -> alpha == 0);
    }
}