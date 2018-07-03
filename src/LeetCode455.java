import java.util.Arrays;

public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {

        //先排序
        //g是孩子 s是饼干
        Arrays.sort(g);
        Arrays.sort(s);

        int child = g.length-1;
        int cookies = s.length-1;

        int count = 0;

        while(cookies>=0&&child>=0){

            //满足
            if(s[cookies]>=g[child]){
                cookies--;
                child--;
                count++;
            }else{

                //不满足，孩子向前移
                child--;

            }



        }


        return count;

    }

}
