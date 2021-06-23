package Unity2;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        int ans=0;
        for(int i = 1;i<sum.length;i++) {
            sum[i] = sum[i-1] + nums[i-1];
            for(int j = 0;j<i;j++){
                if(sum[j]==sum[i]-k)
                    ans++;
            }
        }
        return ans;
    }
}
