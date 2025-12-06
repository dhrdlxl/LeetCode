class Solution {
    fun countSubstrings(s: String, t: String): Int {
        var answer = 0

        for (len in 1..s.length) {
            if (len > t.length) {
                break
            }
            for (i in 0..s.length - len) {
                for (j in 0..t.length - len) {
                    if (s.substring(i, i + len).zip(t.substring(j, j + len)).count { (a, b) -> a != b } == 1) {
                        answer++
                    }
                }
            }
        }

        return answer
    }
}