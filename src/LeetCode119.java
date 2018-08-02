import java.util.ArrayList;
import java.util.List;

public class LeetCode119 {

    public static void main(String[] args) {
        getRow(3);
    }

    public static List<Integer> getRow(int rowIndex) {


        int [] array = new int [34];

        array[0]=1;

        array[1]=1;

        //要一直算到第row行
        for(int i=2;i<=rowIndex;i++){

            //对于每一列，从右边开始构造

            //最右边是1，第一位是1
            array[i]=1;
//            array[0]=1;

            //其余的就是该位置原来的数字+前一位的数字

            for(int j=i-1;j>0;j--){
                array[j] = array[j]+array[j-1];
            }

        }

        List<Integer> result = new ArrayList<>();

        for(int i=0;i<=rowIndex;i++){
            result.add(array[i]);
        }

        return result;

    }

}
