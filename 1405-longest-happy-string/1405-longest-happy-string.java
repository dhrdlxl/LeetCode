class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder answer = new StringBuilder();
        int total = a + b + c;
        int continuedA = 0;
        int continuedB = 0;
        int continuedC = 0;
        
        while (total > 0) {
            if ((a >= b && a >= c && continuedA < 2) || (a > 0 && (continuedB == 2 || continuedC == 2))) {
                a--;
                answer.append('a');
                continuedA++;
                continuedB = 0;
                continuedC = 0;
            }
            else if ((b >= a && b >= c && continuedB < 2) || (b > 0 && (continuedA == 2 || continuedC == 2))) {
                b--;
                answer.append('b');
                continuedB++;
                continuedA = 0;
                continuedC = 0;
            }
            else if ((c >= b && c >= a && continuedC < 2) || (c > 0 && (continuedA == 2 || continuedB == 2))) {
                c--;
                answer.append('c');
                continuedC++;
                continuedA = 0;
                continuedB = 0;
            }
            
            total--;
        }
        
        
        return answer.toString();
    }
}