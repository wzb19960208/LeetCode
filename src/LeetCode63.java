public class LeetCode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        //如果开始就是1，直接就不可能了
        if(obstacleGrid[0][0]==1)
            return 0;


        //行
        int row = obstacleGrid.length;

        //列
        int col = obstacleGrid[0].length;

        //如果终点是1，也是不可能的
        if(obstacleGrid[row-1][col-1]==1)
            return 0;


        for(int i=0;i<row;i++){

            for(int j=0;j<col;j++){

                if(obstacleGrid[i][j]==1)
                    obstacleGrid[i][j]=-1;

            }

        }


        //从后面设置起
        for(int i=row-1;i>=0;i--){

            for (int j=col-1;j>=0;j--){

                if(i==row-1&&j==col-1){
                    obstacleGrid[i][j]=1;
                }else if(i==row-1){

                    //看自己是不是-1
                    if(obstacleGrid[i][j]==-1)
                        continue;

                    //最后一行，要看右边是不是-1
                    if(obstacleGrid[i][j+1]==-1)
                        obstacleGrid[i][j]=0;
                    else
                        //右边有可能是0
                        obstacleGrid[i][j]=obstacleGrid[i][j+1];

                }else if(j==col-1){

                    //看自己是不是-1
                    if(obstacleGrid[i][j]==-1)
                        continue;

                    //最右一列，看看下边是不是-1
                    if(obstacleGrid[i+1][j]==-1)
                        obstacleGrid[i][j]=0;
                    else
                        //下边有可能是0
                        obstacleGrid[i][j]=obstacleGrid[i+1][j];

                }else{

                    if(obstacleGrid[i][j]==-1)
                        continue;
                    else{

                        int right = obstacleGrid[i][j+1];
                        int next = obstacleGrid[i+1][j];

                        if(right!=-1)
                            obstacleGrid[i][j]+=right;
                        if(next!=-1)
                            obstacleGrid[i][j]+=next;

                    }

                }

            }

        }


        return obstacleGrid[0][0];

    }

}
