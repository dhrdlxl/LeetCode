class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int leftNumber = numbers[left];
            int rightNumber = numbers[right];
            
            if (leftNumber + rightNumber < target) {
                left++;
            } else if (leftNumber + rightNumber > target) {
                right--;
            } else {
                answer[0] = left + 1;
                answer[1] = right + 1;
                break;
            }
        }
        
        return answer;
    }
}