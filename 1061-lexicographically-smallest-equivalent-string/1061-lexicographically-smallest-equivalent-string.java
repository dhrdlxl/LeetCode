class Solution {
    private int[] parent;
    
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder answer = new StringBuilder();
        parent = new int['z' - 'a' + 1];
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            int alpha1 = find(s1.charAt(i) - 'a');
            int alpha2 = find(s2.charAt(i) - 'a');
            
            if (alpha1 < alpha2) {
                parent[alpha2] = alpha1;
            } else if (alpha1 > alpha2) {
                parent[alpha1] = alpha2;
            }
        }
        
        for (int i = 0; i < baseStr.length(); i++) {
            answer.append((char)('a' + (find(baseStr.charAt(i) - 'a'))));
        }
        
        return answer.toString();
    }
    
    private int find(int target) {
        if (parent[target] == target) {
            return target;
        }
        return find(parent[target]);
    }
}