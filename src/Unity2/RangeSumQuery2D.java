package Unity2;

public class RangeSumQuery2D {
    private int[][] sum;

    public RangeSumQuery2D(int[][] matrix) {
        sum = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                sum[i][j] = get_sum(i-1,j)+get_sum(i,j-1)-get_sum(i-1,j-1)+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return get_sum(row2,col2) - get_sum(row1-1,col2) - get_sum(row2,col1-1) + get_sum(row1-1,col1-1);
    }

    private int get_sum(int i , int j){
        if(i>=0&&j>=0) return sum[i][j];
        return 0;
    }
}
