import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class LeetCode242 {

    public static void main(String[] args) {


        String s = "rat";
        String t = "car";

        System.out.println(isAnagram2(s,t));

    }

    /**
     * 如果只有26个小写字母
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram2(String s, String t){

        int tlen = t.length();
        int slen = s.length();

        //长度一样，才是
        if(tlen!=slen)
            return false;

        int [] ss = new int[27];
        int [] tt = new int[27];

        for(int i=0;i<slen;i++){
            ss[s.charAt(i)-'a']++;
        }

        for (int i=0;i<tlen;i++){
            tt[t.charAt(i)-'a']++;
        }

        for(int i=0;i<27;i++){
            if(ss[i]!=tt[i])
                return false;
        }


        return true;

    }


    /**
     * 如果是unicode
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t){

        int tlen = t.length();
        int slen = s.length();

        //长度一样，才是
        if(tlen!=slen)
            return false;

        //判断t是不是s的异构
        HashMap<Character,Integer> map = new HashMap();

        //把s放进map
        for(int i=0;i<slen;i++){

            if(map.get(s.charAt(i))==null){
                map.put(s.charAt(i),1);
            }else{
                int temp = map.get(s.charAt(i));
                map.put(s.charAt(i),temp+1);
            }

        }


        //遍历t
        for(int i=0;i<tlen;i++){

            //如果map不存在的，肯定不是
            if(map.get(t.charAt(i))==null){
                return false;
            }else{
                //如果出现了一个，就消耗掉
                int temp = map.get(t.charAt(i));
                map.put(t.charAt(i),temp-1);
            }

        }

        //刚好全部为0，就说明一一对应了
        Collection<Integer> collection = map.values();

        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()){
            if(iterator.next()!=0)
                return false;
        }

        return true;




    }

}
