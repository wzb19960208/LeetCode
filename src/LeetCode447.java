import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class LeetCode447 {

    public static void main(String[] args) {

    }

    public int numberOfBoomerangs(int[][] points){

        int cnt = 0;

        for(int i=0;i<points.length;i++){

            /**
             * 对每个i，计算每个点到i的距离，然后放进map里，距离---->相同距离的点数
             * 不怕重复，因为对于每个不同的i开头，就是不同的元组了
             */

            HashMap<Integer,Integer> map = new HashMap<>();

            for(int j=0;j<points.length;j++){

                if(j==i)
                    continue;

                int dis = dis(points[i],points[j]);

                if(map.get(dis)==null){
                    map.put(dis,1);
                }else{
                    map.put(dis,map.get(dis)+1);
                }

            }

            /**
             * 遍历这个map，0，1，代表没有，>=2 才算
             * 会有n*n-1个
             * 因为Cn 2 n里面选2个，然后这两个又是注意顺序的要*2
             *
             */

            Collection<Integer> values = map.values();

            Iterator<Integer> iterator = values.iterator();

            while(iterator.hasNext()){
                int n = iterator.next();
                if(n<2){

                }else{
                    cnt+=(n*(n-1));
                }
            }

        }

        return cnt;

    }

    public int dis(int a[],int b[]){

        int e1 = a[0]-b[0];
        int e2 = a[1]-b[1];
        return e1*e1+e2*e2;

    }

}
