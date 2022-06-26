class Solution {
    HashSet<List<Integer>> answer = new HashSet<List<Integer>>();
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        for (int a = 0; a < nums.length - 3; a++) {
            for (int b = a + 1; b < nums.length - 2; b++) {
                int c = b + 1;
                int d = nums.length - 1;
                
                while (c < d) {
                    long sum = (long)(nums[a] + nums[b]) + (long)(nums[c] + nums[d]);
                    
                    if (sum < target) {
                        c++;
                    } else if (sum == target) {
                        answer.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                    } else {
                        d--;
                    }
                }
            }
        }

        return new ArrayList(answer);
    }
}