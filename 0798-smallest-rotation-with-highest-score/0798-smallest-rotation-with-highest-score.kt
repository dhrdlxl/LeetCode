class Solution {
    fun bestRotation(nums: IntArray): Int {
        val n = nums.size
        val trigger = Array(n) { 0 }

        for (i in 0 until n) {
            trigger[(i + 1) % n]++
            trigger[(i - nums[i] + 1 + n) % n]--
        }

        var answer = 0
        var maxCount = -1
        var count = 0

        for (i in 0 until n) {
            count += trigger[i]

            if (maxCount < count) {
                maxCount = count
                answer = i
            }
        }

        return answer
    }
}