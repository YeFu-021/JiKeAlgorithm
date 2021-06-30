package Unity4;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private List<List<Integer>> ans;
    private List<Integer> set; // 存放选择


    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        set = new ArrayList<>();
        findSubsets(nums,0);// 从index为0处开始递归
        return ans;
    }

    private void findSubsets(int[] nums,int index){
        // 终止条件
        if (index==nums.length){
            ans.add(new ArrayList<>(set));
//            ans.add(set);
            return;
        }
        // 如果当前index不选
        findSubsets(nums,index+1);
        // 当前层要选
        set.add(nums[index]);
        findSubsets(nums,index+1);
        //恢复现场
        set.remove(set.size()-1);
    }
}
