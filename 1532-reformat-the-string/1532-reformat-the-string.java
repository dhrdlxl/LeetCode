class Solution {
    public String reformat(String s) {
        Queue<Character> alphabet = new LinkedList<>();
        Queue<Character> number = new LinkedList<>();

        for (Character ch : s.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                number.add(ch);
            } else {
                alphabet.add(ch);
            }
        }

        if (Math.abs(alphabet.size() - number.size()) > 1) {
            return "";
        }

        if (alphabet.size() > number.size()) {
            return getAnswer(alphabet, number);
        }

        return getAnswer(number, alphabet);
    }

    private String getAnswer(Queue<Character> a, Queue<Character> b) {
        StringBuilder sb = new StringBuilder();

        while (b.size() > 0) {
            sb.append(a.remove());
            sb.append(b.remove());
        }

        if (a.size() > 0) {
            sb.append(a.remove());
        }
        
        return sb.toString();
    }
}