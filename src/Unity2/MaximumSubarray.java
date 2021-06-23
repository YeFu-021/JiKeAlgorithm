package Unity2;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length+1];
        int[] min_sum = new int[nums.length+1];
        int max_sum = Integer.MIN_VALUE;
        sum[0] = 0;
        min_sum[0] = Integer.MAX_VALUE;
        for(int i = 1;i<sum.length;i++){
            sum[i] = sum[i-1] + nums[i-1];
            min_sum[i] = Math.min(min_sum[i-1],sum[i]);
            max_sum = Math.max(max_sum,sum[i]-min_sum[i-1]);
        }

        return max_sum;
    }
}
