import java.util.HashSet;
import java.util.Iterator;

public class LeetCode349 {

    public static void main(String[] args) {

        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        int [] result = intersection(nums1,nums2);

        for (int i:result
             ) {

            System.out.println(i);

        }


    }

    public static int[] intersection(int[] nums1, int[] nums2){

        HashSet set = new HashSet();
        HashSet result = new HashSet();

        int len1 = nums1.length;
        int len2 = nums2.length;

        /**
         * set寻找是hash，比遍历nums1快
         */
        for(int i=0;i<len1;i++){
            set.add(nums1[i]);
        }


        for(int i=0;i<len2;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }

        int [] end = new int[result.size()];

        int count = 0;

        Iterator iterator = result.iterator();

        while(iterator.hasNext()){
            end[count++]=(int)iterator.next();
        }

        return end;

    }

}
