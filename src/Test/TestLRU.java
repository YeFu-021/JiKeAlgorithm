package Test;

import Unity3.LRU;

public class TestLRU {
    public static void main(String[] args) {
        LRU lru = new LRU(2);
        //["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        lru.put(1,1);
        lru.put(2,2);
        lru.get(1);
        lru.put(3,3);
        lru.get(2);
    }
}
