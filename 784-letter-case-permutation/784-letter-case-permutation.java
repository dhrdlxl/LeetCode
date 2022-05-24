class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> answer = new ArrayList<String>();
        
        permutation(answer, new StringBuilder(), s, 0);
        
        return answer;
    }
    
    private void permutation(List<String> answer, StringBuilder str, String s, int step) {
        if (s.length() == step) {
            answer.add(str.toString());
            return;
        }
        if ('a' <= s.charAt(step) && s.charAt(step) <= 'z') {
            str.append((char)('A' + s.charAt(step) - 'a'));
            permutation(answer, str, s, step + 1);
            str.deleteCharAt(step);
        } else if ('A' <= s.charAt(step) && s.charAt(step) <= 'Z') {
            str.append((char)('a' + s.charAt(step) - 'A'));
            permutation(answer, str, s, step + 1);
            str.deleteCharAt(step);
        }
        
        str.append(s.charAt(step));
        permutation(answer, str, s, step + 1);
        str.deleteCharAt(step);
            
    }
}