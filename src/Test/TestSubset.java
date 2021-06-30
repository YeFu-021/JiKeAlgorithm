package Test;

import Unity4.Subsets;

import java.util.List;

public class TestSubset {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 3});
        System.out.println("list = " + list);
    }
}
