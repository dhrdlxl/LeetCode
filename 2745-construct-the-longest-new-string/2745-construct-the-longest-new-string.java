class Solution {
    public int longestString(int x, int y, int z) {
        return (z + Math.min(x, y) * 2 + (x != y ? 1 : 0)) * 2;
    }
}