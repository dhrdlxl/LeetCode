class WordDictionary {
    private WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary['z' - 'a' + 1];
        isEnd = false;
    }
    
    public void addWord(String word) {
        WordDictionary cur = this;

        for (char alphabet: word.toCharArray()) {
            if (cur.children[alphabet - 'a'] == null) {
                cur.children[alphabet - 'a'] = new WordDictionary();
            }
            cur = cur.children[alphabet - 'a'];
        }

        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        WordDictionary cur = this;

        for (int i = 0; i < n; i++) {
            char alphabet = word.charAt(i);

            if (alphabet == '.') {
                for (WordDictionary wd: cur.children) {
                    if (wd != null && wd.search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (cur.children[alphabet - 'a'] == null) {
                return false;
            }
            cur = cur.children[alphabet - 'a'];
        }

        return cur != null && cur.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */