import java.util.*;

class Solution {
    public int answer;
    public boolean[][] mask;
    public int n;
    public int[][] move = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    
    public int totalNQueens(int n) {
        this.n = n;
        
        for (int col = 0; col < n; col++) {
            mask = new boolean[n][n];
            
            // 첫 시작 점
            masking(col);
            simulation(col, 1);
        }
        
        return answer;
    }
    
    public boolean checkValid(int row, int col) {
        if (row >= 0 && col >= 0 && row < n && col < n) {
            return true;
        }
        
        return false;
    }
    
    public void masking(int curPos) {
        int row = curPos / n;
        int col = curPos % n;
        mask[row][col] = true;
        
        for (int direction = 0; direction < 8; direction++) {
            for(int i = 1; i < n; i++) {
                int nextRow = row + move[direction][0] * i;
                int nextCol = col + move[direction][1] * i;
                
                if (checkValid(nextRow, nextCol)) {
                    mask[nextRow][nextCol] = true;
                } else {
                    break;
                }
            }
        }
    }
    
    public void simulation(int curPos, int count) {
        if (count == n) {
            answer++;
            return;
        }
        boolean[][] maskCopy = new boolean[n][n];
        //mask copy
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                maskCopy[r][c] = mask[r][c];
            }
        }
        
        //다음 좌표 선택
        for (int nextPos = n * count; nextPos < n * (count + 1); nextPos++) {
            int nextRow = nextPos / n;
            int nextCol = nextPos % n;
            
            if (mask[nextRow][nextCol] == false) {
                //다음 좌표에 의해 못가는 부분 마스킹
                masking(nextPos);
                
                //다음 칸
                simulation(nextPos, count + 1);
                
                //마스킹 복원
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        mask[r][c] = maskCopy[r][c];
                    }
                }
            }
        }
        return;
    }
    
}