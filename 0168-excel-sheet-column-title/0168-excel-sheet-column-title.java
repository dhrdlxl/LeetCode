class Solution {
    private int n = 'z' - 'a' + 1;

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            sb.insert(0, (char)('A' + (columnNumber % n)));
            columnNumber /= n;
        }

        return sb.toString();
    }
}