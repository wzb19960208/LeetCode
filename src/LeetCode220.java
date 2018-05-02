import java.util.TreeSet;

public class LeetCode220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){

        TreeSet<Long> set = new TreeSet<>();


        //set.ceiling(); 方法返回在这个集合中大于或者等于给定元素的最小元素 就是说大于给定元素，并且最接近他的
        //set.floor(); 方法返回在这个集合中小于或者等于给定元素的最大元素


        int l=0,r=0;

        while(r<nums.length){

            //如果找到
            // |[i]-[j]|<=t  即    -t<=[i]-[j]<=t      [j]-t=<[i]<=[j]+t  所以对每个r，只需在set里面找到符合条件的 [i]即可 ，很明显，这需要一个排序，或者对区间里面的[I]都遍历看看有没有

            Long temp = set.ceiling((long)nums[r]-t);

            //temp是最接近[j]-t的数了，如果temp都不能小于等于[j]+t ，那么后面的肯定也不行


            /**
             * [0,2147483647]
             1
             2147483647
             [-2147483648,-2147483647]
             3
             3
             只要是int相加相减的地方，就可能会出现溢出
             */
            if(temp!=null&&temp<=(long)(nums[r])+t){
                return true;
            }else{

                //没找到
                set.add((long)nums[r]);

                if(set.size()>k){
                    set.remove((long)nums[r-k]);
                }

                r++;

            }


        }

        return false;

    }

}
