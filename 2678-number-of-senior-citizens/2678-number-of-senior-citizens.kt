class Solution {
    fun countSeniors(details: Array<String>): Int {
        return details.count {it.substring(11, 13).toInt() > 60}
    }
}