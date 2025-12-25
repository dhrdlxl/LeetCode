class Solution {
    fun findPeaks(mountain: IntArray): List<Int> =
    (1 .. mountain.size - 2).filter {
        i -> mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]
    }
}