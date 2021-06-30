package Test;

import Unity4.Permutation_II_secend;
import Unity4.Permutations;

import java.util.List;

public class TestPer {
    public static void main(String[] args) {
        Permutation_II_secend iiSecend = new Permutation_II_secend();
        List<List<Integer>> list = iiSecend.permuteUnique(new int[]{1,1,2});
        System.out.println("list = " + list);
    }
}
