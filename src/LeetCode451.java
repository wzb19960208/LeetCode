import java.util.*;

public class LeetCode451 {

    public static void main(String[] args) {

        String s = "Aabb";

        System.out.println(frequencySort(s));

        //这样构建stringbuilder 会有问题
        //看源码好像也没问题啊
//        System.out.println(new StringBuilder('k'));
//
//        StringBuilder sb = new StringBuilder();
//
//        sb.append('k');
//
//        System.out.println(sb);

    }


    public static String frequencySort(String s){

        if(s==null)
            return null;

        if(s.length()==0)
            return s;

        HashMap<Character,Integer> map = new HashMap();

        //先拿到每个字符对应的出现次数
        int len = s.length();

        for(int i=0;i<len;i++){
            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),1);
            }else{
                int temp = map.get(s.charAt(i));
                map.put(s.charAt(i),temp+1);
            }
        }

        //将次数->字符
        HashMap<Integer,StringBuilder> map1 = new HashMap<>();

        Iterator<Map.Entry<Character,Integer>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<Character,Integer> entry = iterator.next();
            char key = entry.getKey();
            int value = entry.getValue();

            if(map1.get(value)==null){
                StringBuilder temp = new StringBuilder();
                temp.append(key);
                map1.put(value,temp);
            }else{
                StringBuilder temp = map1.get(value);
                temp.append(key);
                map1.put(value,temp);
            }

        }

        //对map1的数字排序
        //升序的
        Set<Integer> nums = map1.keySet();
        TreeSet<Integer> sortSet = new TreeSet<>(nums);

        StringBuilder sb = new StringBuilder();

        Iterator<Integer> iterator1 = sortSet.iterator();

        while (iterator1.hasNext()){

            int key = iterator1.next();

            StringBuilder value = map1.get(key);

            for(int i=0;i<value.length();i++){

                for(int j=0;j<key;j++){
                    sb.append(value.charAt(i));
                }

            }


        }




        //System.out.println(sortSet);

        return sb.reverse().toString();

    }

    /**
     * 降序排序
     */
    static class MyComparator implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {

//            o1 = (Integer)o1;
//            o2 = (Integer)o2;
            //不能直接转

            Integer i1 = (Integer)o1;
            Integer i2 = (Integer)o2;

            if(i1>i2){
                return -1;
            }else if(i1<i2){
                return 1;
            }else{
                return 0;
            }

        }
    }

}
