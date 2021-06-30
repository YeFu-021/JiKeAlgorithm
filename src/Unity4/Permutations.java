package Unity4;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> ans;
    private List<Integer> set;
    private boolean[] used;// 记录索引数是否被使用过
    private int[] num;// num是nums的copy  用于给permute之外的函数使用的
    private int n;// 记录nums的长度

    public List<List<Integer>> permute(int[] nums) {
        ans= new ArrayList<>();
        set=new ArrayList<>();
        n = nums.length;
        used = new boolean[n];
        num = new int[n];
        for (int i = 0; i<n;i++) num[i]=nums[i];
        dfs(0);
        return ans;
        }

    public void dfs(int depth){

        // 递归结束条件
        if (depth==n) {
            if (!ans.contains(new ArrayList<>(set)))
                ans.add(new ArrayList<>(set));
            return;
        }

        // 本层逻辑
        for (int i = 0;i<n;i++){
            // 如果使用过 则继续往下去找没使用过的
            if (used[i]) continue;
            // 将使用符号调true
            used[i] = true;
            set.add(num[i]);
            dfs(depth+1);
            // 恢复现场
            set.remove(set.size()-1);
            used[i] = false;
        }
    }
}
