class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int lHeight = height[left];
            int rHeight = height[right];
            int container = 0;
            
            if (lHeight > rHeight) {
                container = (rHeight * (right - left));
                right--;
            } else {
                container = (lHeight * (right - left));
                left++;
            }
            
            if (container > answer) {
                answer = container;
            }
        }
        
        return answer;
    }
}