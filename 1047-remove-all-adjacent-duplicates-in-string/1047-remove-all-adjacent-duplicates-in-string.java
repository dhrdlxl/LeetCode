class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        
        for (char alphabet : s.toCharArray()) {
            len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == alphabet) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(alphabet);
            }
        }

        return sb.toString();
    }
}