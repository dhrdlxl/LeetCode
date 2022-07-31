class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxBlank = 0;
        for (int row = 0; row < wall.size(); row++) {
            int blankIndex = 0;
            
            for (int col = 0; col < wall.get(row).size() - 1; col++) { // 가장자리 제외
                blankIndex += wall.get(row).get(col);
                
                map.put(blankIndex, map.getOrDefault(blankIndex, 0) + 1);
                
                if (maxBlank < map.get(blankIndex)) {
                    maxBlank = map.get(blankIndex);
                }
            }
        }
        
        return wall.size() - maxBlank;
    }
}