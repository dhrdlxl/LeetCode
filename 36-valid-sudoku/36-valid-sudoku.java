class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int a = 0; a < 9; a++) {
            int[] mask = {0, 0, 0}; //row, col, 3 x 3 sub-boxes
            
            for (int b = 0; b < 9; b++) {
                int[][] positions = {{a, b}, {b, a}, {a / 3 * 3 + b / 3, a % 3 * 3 + b % 3}};
                int type = 0; //0: row, 1: col, 2: 3 x 3 sub-boxes
                
                for (int[] position : positions) {
                    int row = position[0];
                    int col = position[1];
                    
                    if (board[row][col] != '.') {
                        int num = board[row][col] - '0';
                        
                        if ((mask[type] & (1 << num)) > 0) {// check valid
                            return false;
                        }
                        mask[type] |= (1 << num);
                    }
                    
                    type++;
                }
            }
        }
        
        
        return true;
    }
}