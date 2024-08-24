class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] prev = new int[n];
        int maxCountIndex = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            prev[i] = -1;
            
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (count[i] < count[j] + 1) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                     }
                }
            }
            
            if (count[maxCountIndex] < count[i]) {
                maxCountIndex = i;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        while (maxCountIndex >= 0) {
            answer.add(nums[maxCountIndex]);
            maxCountIndex = prev[maxCountIndex];
        }
        
        return answer;
    }
}