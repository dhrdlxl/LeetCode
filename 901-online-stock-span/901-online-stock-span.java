class StockSpanner {
    private ArrayList<Integer> stocks;
    
    public StockSpanner() {
        stocks = new ArrayList<>();
        stocks.add(1000000);
    }
    
    public int next(int price) {
        int index = stocks.size() - 1;
        int span = 1;
        
        while (stocks.get(index) <= price) {
            span++;
            index--;
        }
        
        stocks.add(price);
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */