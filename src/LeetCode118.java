import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {

        //0行返回什么？

        //设置好第一行，后续的自动生成即可
        List<List<Integer>> result = new ArrayList<>();

        if (numRows==0)
            return result;

        List<Integer> temp = new ArrayList<>();

        temp.add(1);

        result.add(temp);
        if(numRows==1)
            return result;

        temp = new ArrayList<>();

        temp.add(1);
        temp.add(1);

        result.add(temp);

        if(numRows==2)
            return result;

        //从第三行开始即可
        for(int i=2;i<numRows;i++){

            //构造每一行，第n行的个数是n,第一个和最后一个数字都是1

            List<Integer> current = new ArrayList<>();

            //头
            current.add(1);

            List<Integer> last = result.get(i-1);

            //中间就是j-1,j两个位置
            //第i行的个数是i+1个，因为i是比行数少一的
            for(int j=1;j<i;j++){
                current.add(last.get(j-1)+last.get(j));
            }

            //尾
            current.add(1);

            result.add(current);


        }

        return result;

    }

}
