import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LeetCodeSet1 {
    //查找表类算法 1
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }

        //这样是为了去重
        for(int i=0;i<nums2.length;i++){
            if(set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }

        //set2里面就是结果
        int [] result = new int[set2.size()];

        Iterator<Integer> iterator = set2.iterator();

        int count = 0;

        while (iterator.hasNext()){
            result[count++]=iterator.next();
        }

        return result;
    }
}
