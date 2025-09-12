class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Set<String> mask = new HashSet<>();
        int changeCount = 1;
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                String word = q.remove();
                if (word.equals(endWord)) {
                    return changeCount;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
                        char[] alphabets = word.toCharArray();
                        alphabets[j] = alphabet;
                        String newWord = new String(alphabets);

                        if (words.contains(newWord) && !mask.contains(newWord)) {
                            q.add(newWord);
                            mask.add(newWord);
                        }
                    }
                }
            }
            changeCount++;
        }

        return 0;
    }
}