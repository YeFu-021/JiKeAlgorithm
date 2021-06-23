/**
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 1 开始计数
 * 所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity2;

public class TwoSumii {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针法
        int j = numbers.length-1;
        for (int i = 0;i<j;i++){
            while(i<j&&numbers[i]+numbers[j]>target) j--;
            if (i<j&&numbers[i]+numbers[j]==target)
                return new int[]{i + 1, j + 1};
        }
        return new int[]{};
    }
}
