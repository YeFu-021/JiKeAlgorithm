package Unity2;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0 ;
        int[] sum = new int[nums.length+1];
        int[] count = new int[nums.length+1];// 用来统计sum[]每个元素出现个数
        count[sum[0]]++;  //?
        // 对于数组中的数 进行对二取模运算 同时计算前缀和 前缀和在count数组中对应的数要++
        for(int i = 1 ; i<=nums.length ; i++){
            sum[i] = sum[i-1] + nums[i-1]%2;
            count[sum[i]]++;
        }

        for(int i = 1 ; i<sum.length;i++){
            if(sum[i]-k>=0){ // 这里要大于等于
                ans = ans + count[sum[i]-k];
            }
        }
        return ans;
    }
}
