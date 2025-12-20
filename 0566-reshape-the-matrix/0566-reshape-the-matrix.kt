class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size

        if (m * n != r * c || (m == r && n == c)) {
            return mat
        }

        var count = 0
        val answer = Array(r) {IntArray(c)}

        for (oldR in 0 .. m-1) {
            for (oldC in 0 .. n-1) {
                answer[count / c][count % c] = mat[oldR][oldC]
                count++
            }
        }

        return answer
    }
}