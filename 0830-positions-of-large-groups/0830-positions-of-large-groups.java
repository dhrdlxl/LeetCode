class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        char before = ' ';
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char alphabet = s.charAt(i);
            if (before == alphabet) {
                count++;
            } else {
                if (count >= 3) {
                    addAnswer(answer, i, count);
                }
                count = 1;
            }
            
            before = alphabet;
        }
        
        if (count >= 3) {
            addAnswer(answer, s.length(), count);
        }
        
        return answer;
    }
    
    private void addAnswer(List<List<Integer>> answer, int index, int count) {
        List<Integer> group = new ArrayList<>();
        group.add(index - count);
        group.add(index - 1);
        answer.add(group);
    }
}