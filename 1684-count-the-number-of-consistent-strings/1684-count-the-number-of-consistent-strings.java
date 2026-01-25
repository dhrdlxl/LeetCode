class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int answer = 0;
        int allowedBit = getBit(allowed);
        int wordBit = 0;

        for (String word : words) {
            wordBit = getBit(word);

            if (((~allowedBit) & wordBit) == 0) {
                answer++;
            }
        }

        return answer;
    }

    private int getBit(String word) {
        int bit = 0;

        for (char alphabet : word.toCharArray()) {
            bit |= (1 << (alphabet - 'a'));
        }

        return bit;
    }
}