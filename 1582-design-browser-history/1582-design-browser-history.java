class BrowserHistory {
    private Stack<String> history;
    private Stack<String> temp;

    public BrowserHistory(String homepage) {
        history = new Stack<>();
        temp = new Stack<>();
        history.push(homepage);
    }
    
    public void visit(String url) {
        history.push(url);
        if (!temp.isEmpty()) {
            temp.clear();
        }
    }
    
    public String back(int steps) {
        while (--steps >= 0 && history.size() > 1) {
            temp.push(history.pop());
        }

        return history.peek();
    }
    
    public String forward(int steps) {
        while (--steps >= 0 && !temp.isEmpty()) {
            history.push(temp.pop());
        }

        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */