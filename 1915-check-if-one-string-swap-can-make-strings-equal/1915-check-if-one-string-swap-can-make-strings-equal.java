class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] diffIndex = new int[2];
        int diffCount = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount == 2) {
                    return false;
                }
                diffIndex[diffCount] = i;
                diffCount++;
            }
        }

        return diffCount == 0 || 
        (diffCount == 2 
        && s1.charAt(diffIndex[0]) == s2.charAt(diffIndex[1])
        && s1.charAt(diffIndex[1]) == s2.charAt(diffIndex[0]));
    }
}