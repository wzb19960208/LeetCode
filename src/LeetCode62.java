public class LeetCode62 {

    public int uniquePaths(int m, int n) {

        int [][] matrix = new int[m][n];

        //从最后一个开始，最后一行，最后一烈，这样逆序，一直到【0】【0】
        for(int i=m-1;i>=0;i--){

            for(int j=n-1;j>=0;j--){

                if(i==m-1&&j==n-1){
                    matrix[i][j]=1;
                }else if(i==m-1){
                    //最后一行,无论如何都是只有一种走法，就是往右走
                    matrix[i][j]=1;
                }else if(j==n-1){
                    //最右列也只有一直往下走
                    matrix[i][j]=1;
                }else{

                    //其他就是右边的方法数加上右边的方法数
                    int right = matrix[i][j+1];
                    int next = matrix[i+1][j];
                    matrix[i][j]=right+next;

                }

            }

        }

        return matrix[0][0];

    }

}
