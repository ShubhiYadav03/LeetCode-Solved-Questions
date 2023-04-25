class SmallestInfiniteSet {
    SortedSet<Integer> smallestInfiniteSet;
    public SmallestInfiniteSet() {
        smallestInfiniteSet = new TreeSet<>();
        
        for(int i = 1; i < 1001; i++){
            smallestInfiniteSet.add(i);
        }
    }
    
    public int popSmallest() {
        if(smallestInfiniteSet.size() > 0) {
            int f = smallestInfiniteSet.first();
            smallestInfiniteSet.remove(f);
            return f;
        }
        return -1;
    }
    
    public void addBack(int num) {
        smallestInfiniteSet.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */