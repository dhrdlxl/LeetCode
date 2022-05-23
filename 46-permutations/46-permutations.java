class Solution {
    private List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        
        dfs(nums, 0, new ArrayList<>());
        
        return answer;
    }
    
    private void dfs(int[] nums, int step, ArrayList<Integer> newList) {
        if (nums.length == step) {
            answer.add((List)newList.clone());

            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!newList.contains(nums[i])) {
                newList.add(nums[i]);
                
                dfs(nums, step + 1, newList);
                
                newList.remove(step);
            }
        }
    }
}