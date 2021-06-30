package Test;

import Unity1.ResizeableArray;

public class TestRA {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ResizeableArray r = new ResizeableArray(arr);
        r.print();
        r.delete(3);
        r.print();
        r.delete(5);
        r.print();
    }
}
