import java.util.*;

public class LeetCode350 {

    public static void main(String[] args) {

        int [] nums1 = {1,2,1};
        int [] nums2 ={2,2};
        int [] result = intersect2(nums1,nums2);

        for (int i:result
             ) {
            System.out.println(i);
        }

    }

    //如果有序
    public static int[] intersect2(int[] nums1, int[] nums2){

        //模拟有序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        //如果nums1的长度比nums2的长，那么交集数组，肯定是nums2的长度，反之也是
        //交集肯定是《=较短一组的长度

        int [] a;
        int [] b;
        int [] result;
        int cnt=0;


        //长的是b
        //短的是a
        //从短的里面遍历，看是否在长的里面就行了呃
        if(nums1.length>nums2.length){
                a=nums2;
                b=nums1;
        }else{
            a=nums1;
            b=nums2;
        }

        result = new int [a.length];

        int b_start = 0;

        int alen = a.length;
        int blen = b.length;

        for(int i=0;i<alen;i++){

            //因为是有序的，b_start前面的，肯定比他小，因为前面导致的
            for(int j=b_start;j<blen;j++){

                if(a[i]>b[j]){
                    b_start++;
                }else if(a[i]==b[j]){
                    result[cnt++]=a[i];
                    b_start++;
                    //找到一个，就应该break了，不然一个a中一个元素，把b中的全匹配完了
                    break;
                }else{
                    //当前b的元素比a大了，这个a不用看了，肯定不存在于b
                    break;
                }

            }

        }

        return Arrays.copyOf(result,cnt);



    }


    public static int[] intersect(int[] nums1, int[] nums2){

        Map map = new HashMap();
        List<Integer> result = new ArrayList<>();

        int len1 = nums1.length;
        int len2 = nums2.length;

        //nums1放进map
        for(int i=0;i<len1;i++){
            if (map.get(nums1[i])==null){
                map.put(nums1[i],1);
            }else{
                int temp = (Integer) map.get(nums1[i]);
                map.put(nums1[i],temp+1);
            }
        }

        //
        for(int i=0;i<len2;i++){

            Integer temp = (Integer) map.get(nums2[i]);

            //如果存在
            if (temp!=null){

                //且大于0
                if(temp>0){

                    //消耗
                    map.put(nums2[i],--temp);

                    //加进result中
                    result.add(nums2[i]);

                }

            }

        }

        //null
        //System.out.println("默认值"+map.get(1));

        int [] end = new int[result.size()];
        int count = 0;

        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            end[count++]=iterator.next();
        }

        return end;

    }


}


