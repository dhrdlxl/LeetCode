class Solution {
    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;

        for (char direction : moves.toCharArray()) {
            if (direction == 'U') {
                vertical++;
            } else if (direction == 'D') {
                vertical--;
            } else if (direction == 'R') {
                horizontal++;
            } else if (direction == 'L') {
                horizontal--;
            }
        }

        return vertical == 0 && horizontal == 0 ? true : false;
    }
}