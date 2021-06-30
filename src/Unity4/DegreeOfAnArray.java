/**
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity4;

import java.util.HashMap;

public class DegreeOfAnArray {
    HashMap<Integer, Integer> left = new HashMap();
    HashMap<Integer, Integer> right = new HashMap();
    HashMap<Integer, Integer> count = new HashMap();
    int degree;
    public int findShortestSubArray(int[] nums) {

        for (int i = 0 ;i<nums.length;i++){
            // 该数第一次出现
            if (!count.containsKey(nums[i])) left.put(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0) + 1);
            right.put(nums[i],i);
        }

        degree = getDegree(count);
        Integer ans = Integer.MAX_VALUE;
        for (int i :count.keySet()){
            if (count.get(i)==degree){
                ans = Math.min(ans,right.get(i)-left.get(i)+1);
            }
        }
        return ans;
    }

    private int getDegree(HashMap<Integer, Integer> count) {
        int res = 0;
        for (Integer i : count.keySet()){
            res = Math.max(count.get(i),res);
        }
        return res;
    }
}
