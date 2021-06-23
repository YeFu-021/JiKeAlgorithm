package Unity2;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int first;
        int end ;
        int nums;
        int[] delta = new int[n+2];
        for(int i = 0 ;i<bookings.length;i++){
            first = bookings[i][0];
            end = bookings[i][1];
            nums = bookings[i][2];
            delta[first] +=nums;
            delta[end+1] -=nums;
        }
        int[] a = new int[n+1];
        a[0] = 0;
        for(int i=1;i<=n;i++){
            a[i] = a[i-1] + delta[i];
        }
        int[] ans = new int[n];
        for(int i = 1;i<=n;i++){
            ans[i-1] = a[i];
        }
        return ans;
    }
}
