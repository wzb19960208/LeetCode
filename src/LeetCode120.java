import java.util.List;

public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int len = triangle.size();

        //最后一行不用改

        //从倒数第二行开始
        for(int i=len-2;i>=0;i--){

            List<Integer> current = triangle.get(i);
            List<Integer> next = triangle.get(i+1);

            //看他的排布状况，不是开头对齐排列的，相邻好像就+0，+1
            //当前这个数字的最短路径 = 当前数字+min{last(当前+0，当前+1)}

            int index = current.size();

            for(int j=0;j<index;j++){

                //因为下一行是比上一行长的，所以最后一个肯定不会溢出
                int now = current.get(j);

                int now0 = next.get(j);
                int now1 = next.get(j+1);

                if(now0<now1){
                    current.set(j,now+now0);
                }else{
                    current.set(j,now+now1);
                }

            }

        }

        //遍历完以后，当前第一列的那个元素就是最短路径
        //一次通过美滋滋
        return triangle.get(0).get(0);





    }

}
