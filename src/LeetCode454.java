import java.util.HashMap;

public class LeetCode454 {

    public static void main(String[] args) {

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D){

        HashMap<Integer,Integer> cd = new HashMap<>();
        int cnt = 0;

        /**
         * C+D的所有可能加上次数
         */
        for(int i=0;i<C.length;i++){

            for(int j=0;j<D.length;j++){

                int temp = C[i]+D[j];

                if(cd.get(temp)==null){
                    cd.put(temp,1);
                }else{
                    cd.put(temp,cd.get(temp)+1);
                }

            }
        }


        /**
         * 遍历A+B
         */
        for(int i=0;i<A.length;i++){

            for (int j=0;j<B.length;j++){

                /**
                 * 去C+D里面找，有没有符合的，因为是hashMap，查找时间是O1
                 */
                int temp = 0 - (A[i]+B[j]);

                if(cd.get(temp)==null){
                    continue;
                }else{
                    cnt+=cd.get(temp);
                }


            }

        }

        return cnt;

    }

}
