class Solution {
    fun countPartitions(nums: IntArray): Int {
        var answer = 0
        var leftSum = 0;
        var rightSum = nums.sum()

        for (i in 0 until nums.size - 1) {
            leftSum += nums[i]
            rightSum -= nums[i]

            if ((leftSum - rightSum) % 2 == 0) {
                answer++
            }
        }

        return answer
    }
} 