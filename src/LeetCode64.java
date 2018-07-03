public class LeetCode64 {

    public int minPathSum(int[][] grid) {


        //从最后一个算起
        int row = grid.length-1;
        int column = grid[0].length-1;

        for(int i=row;i>=0;i--){

            for (int j=column;j>=0;j--){

                if(i==row&&j==column){
                    continue;
                }else if (i==row){
                    //如果是最后一行，就没法向下走了，那么最短路径就是直接加上右边
                    int right = grid[i][j+1];
                    grid[i][j]+=right;
                }else if(j==column){
                    //如果是最右一列，就没法往右走了，那么最短路径就是直接加上下面
                    int next = grid[i+1][j];
                    grid[i][j]+=next;
                }else {
                    //选右边的下边里，最短的路径
                    int right = grid[i][j+1];
                    int next = grid[i+1][j];

                    if(right<next){
                        grid[i][j]+=right;
                    }else{
                        grid[i][j]+=next;
                    }

                }

            }

        }

        return grid[0][0];


    }

}
