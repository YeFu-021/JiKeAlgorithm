/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *  示例 1：
 *
 *  输入：nums = [1,1,2]
 *  输出：
 *  [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *  示例 2：
 *
 *  输入：nums = [1,2,3]
 *  输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 */

package Unity4;

import java.util.ArrayList;
import java.util.List;

public class Permutation_II_secend {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums,0);
        return ans;
    }

    private void dfs(int[] nums,int cur) {
        if (cur == nums.length) {
            List<Integer> line = new ArrayList<>();
            for (int i : nums) {
                line.add(i);
            }
            ans.add(line);
        } else {
            for (int i = cur;i < nums.length;i++) {
                if (canSwap(nums,cur,i)) {
                    swap(nums,cur,i);
                    dfs(nums,cur + 1);
                    // 恢复现场将已经调转位置的两个数换回来
                    swap(nums,cur,i);
                }
            }
        }
    }

    private boolean canSwap(int nums[],int begin,int end) {
        for (int i = begin;i < end;i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int nums[],int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
