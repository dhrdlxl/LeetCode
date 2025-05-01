class Solution {
    public String shortestPalindrome(String s) {
        int index = kmp(s + "#" + new StringBuilder(s).reverse().toString());
        return new StringBuilder(s.substring(index)).reverse() + s;
    }

    private int kmp(String s) {
        int n = s.length();
        int[] pi = new int[n];
        int prefix = 0;
        int suffix = 1;

        while (suffix < n) {
            if (s.charAt(prefix) == s.charAt(suffix)) {
                pi[suffix] = prefix + 1;
                prefix++;
                suffix++;
            } else {
                if (prefix > 0) {
                    prefix = pi[prefix - 1];
                } else {
                    pi[suffix] = 0;
                    suffix++;
                }
            }
        }
        
        return pi[n - 1];
    }
}