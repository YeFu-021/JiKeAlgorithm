/**
 *给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入:n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */

package Unity4;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer>  set = new ArrayList<>();
    private int n;
    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        findSubsets(1);//从1开始
        return ans;
    }

    private void findSubsets(int index){
        // 当set里的数比k大，或者set里的数加上剩下的数也不到k 都不符合条件 直接返回
        if (set.size()>k||set.size()+n-index+1<k) return;
        // 终止条件
        if (index==n+1){
            ans.add(new ArrayList<>(set));
        // ans.add(set);
            return;
        }

        // 如果当前index不选
        findSubsets(index+1);
        // 当前层要选
        set.add(index);
        findSubsets(index+1);
        //  恢复现场
        set.remove(set.size()-1);
    }

}
