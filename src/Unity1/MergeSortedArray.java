/**
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。
 * 你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

package Unity1;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int flag=m+n-1;// 数组1的总长
        int flag1=m-1;// 数组1的有效数的长度
        int flag2=n-1;// 数组2的有效数的长度

        while(flag1>=0||flag2>=0){
            // 注意先判断flag1<0和flag2<0的情况，不然会在判断nums1[flag1]时出现越界
            if(flag1<0){
                nums1[flag--]=nums2[flag2--];
            }
            else if(flag2<0){
                nums1[flag--]=nums1[flag1--];
            }
            else if(nums1[flag1]>nums2[flag2]){
                nums1[flag--]=nums1[flag1--];
            }
            else{
                nums1[flag--]=nums2[flag2--];
            }
        }
    }
}
