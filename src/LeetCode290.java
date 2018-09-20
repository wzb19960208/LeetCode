import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode290 {

    public boolean wordPattern(String pattern, String str) {
        if (pattern==null||pattern.length()==0)
            return false;
        if (str==null||str.length()==0)
            return false;


        String [] array = str.split(" ");

        if(pattern.length()!=array.length)
            return false;

        Map<Character,String> map = new HashMap<>();
        //去重
        Set<Character> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for(int i=0;i<pattern.length();i++){

            String temp = map.get(pattern.charAt(i));

            if(temp==null){
                map.put(pattern.charAt(i),array[i]);
                set1.add(pattern.charAt(i));
                set2.add(array[i]);
            }else {
                //先保证两边是单向对应的
                if(!temp.equals(array[i]))
                    return false;
            }

        }

        if(set1.size()==set2.size())
            return true;
        else
            return false;



    }

}
