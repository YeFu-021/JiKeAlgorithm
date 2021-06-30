/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity4;

import java.util.ArrayList;
import java.util.List;

public class Permutations_II {
    private List<List<Integer>> ans;
    private List<Integer> set;
    private boolean[] used;// 记录索引数是否被使用过
    private int[] num;// num是nums的copy  用于给permute之外的函数使用的
    private int n;// 记录nums的长度

    /**
     * 参考的全排列  在递归返回结束条件中 去重
     * 方法：暴力递归 求出所有的全排序列 去重
     * 优点：易于理解
     *
     * 缺点：时间复杂度高
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            // 判断如果重复 不放入答案中
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
