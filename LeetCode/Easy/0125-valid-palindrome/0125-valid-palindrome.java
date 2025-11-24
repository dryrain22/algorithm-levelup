class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int length = s.length();
        if (s == "" || length == 1) return true;

        StringBuffer sb;

        if (length % 2 == 0) {
            sb = new StringBuffer(s.substring(length/2));
        } else {
            sb = new StringBuffer(s.substring(length/2+1));
        }
        
        String front = s.substring(0, length/2);
        String back = sb.reverse().toString();

        if (front.equals(back)) return true;

        return false; 
    }
}