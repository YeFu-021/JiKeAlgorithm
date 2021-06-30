package Test;

import Unity4.Combinations;

import java.util.List;

public class TestComb {
    public static void main(String[] args) {
        Combinations comb = new Combinations();
        List<List<Integer>> list = comb.combine(4, 2);
        System.out.println("list = " + list);
    }
}
