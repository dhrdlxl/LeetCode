class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> answer = new HashSet<>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String sentence = s.substring(i, i + 10);
            if (set.contains(sentence)) {
                answer.add(sentence);
            }
            set.add(sentence);
        }
            
        return new ArrayList(answer);
    }
}