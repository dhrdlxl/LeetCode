class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String wordJoin1 = Arrays.stream(word1).collect(Collectors.joining());
        String wordJoin2 = Arrays.stream(word2).collect(Collectors.joining());
        
        return wordJoin1.equals(wordJoin2);
    }
}