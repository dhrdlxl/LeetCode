class Solution {
    fun getDescentPeriods(prices: IntArray): Long {
        var answer = 1L
        val contiguousList = mutableListOf<Long>()
        var continued = 1L
        var before = prices[0]

        for (i in 1 .. prices.size - 1) {
            answer++
            
            if (before - prices[i] == 1) {
                continued++
            } else {
                if (continued > 1) {
                    contiguousList.add(continued)
                }
                continued = 1L
            }

            before = prices[i]
        }

        if (continued > 1) {
            contiguousList.add(continued)
        }

        for (count in contiguousList) {
            answer += (count * (count - 1)) / 2
        }

        return answer
    }
}