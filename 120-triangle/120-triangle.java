class Solution {
    private final int MAX = 10001;
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        List<List<Integer>> dp = new ArrayList<>(len);
        dp.add(new ArrayList<Integer>());
        dp.get(0).add(triangle.get(0).get(0));
        
        for (int row = 1; row < len; row++) {
            dp.add(new ArrayList<Integer>());
            
            for (int col = 0; col <= row; col++) {
                int left = (col - 1 >= 0 ? dp.get(row - 1).get(col - 1) : MAX);
                int right = (col < dp.get(row - 1).size() ? dp.get(row - 1).get(col) : MAX);
                
                dp.get(row).add(triangle.get(row).get(col) + min(left, right)); 
            }
        }
        
        int answer = MAX;
        for (int i = 0; i < len; i++) {
            answer = min(answer, dp.get(len - 1).get(i));
        }
                         
        return answer;
    }
    
    private int min(int a, int b) {
        return (a < b ? a : b);
    }
}