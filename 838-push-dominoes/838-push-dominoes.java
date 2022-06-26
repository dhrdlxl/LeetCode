class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder answer = new StringBuilder();
        char[] domino = dominoes.toCharArray();
        int[] check = new int[domino.length];
        
        for (int i = 0; i < check.length; i++) {
            check[i] = -1;
        }
        
        int startIndex = -1;
        for (int i = domino.length - 1; i >= 0; i--) {
            if (domino[i] == 'L') {
                startIndex = i;
                check[i] = startIndex;
            } else if (domino[i] == 'R') {
                check[i] = startIndex;
                startIndex = -1;
            } else if (domino[i] == '.') {
                check[i] = startIndex;
            }
        }
        
        char before = '.';
        for (int i = 0; i < domino.length; i++){
            if (domino[i] == 'R' && check[i] == -1) {
                answer.append('R');
                before = 'R';
            } else if (domino[i] == 'R' && check[i] != -1){
                int count = check[i] - i + 1;
                StringBuilder temp = new StringBuilder();
                
                if (count % 2 == 1) {
                    temp.append('.');
                }
                
                for (int  j = 0; j < count / 2; j++) {
                    temp.insert(0, 'R');
                    temp.append('L');
                }
                
                answer.append(temp);
                i = check[i];
                before = 'L';
            } else if (domino[i] == '.') {
                if (check[i] != -1) {
                    answer.append('L');
                } else if (before == 'R') {
                    answer.append('R');
                } else {
                    answer.append('.');
                }
            } else if (domino[i] == 'L') {
                answer.append('L');
                before = 'L';
            }
        }
        
        
        
        return answer.toString();
    }
}