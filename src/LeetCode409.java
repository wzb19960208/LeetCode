import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LeetCode409 {

    public static void main(String[] args) {

        //A-Z到a-z之间不是连续的 中途还有92~96 不是字母字符
        System.out.println((int)'A');
        System.out.println((char)92);
        System.out.println((int)'a');
    }

    public int longestPalindrome(String s) {

        Map<Character,Integer> map = new HashMap<>();

        int len = s.length();

        for(int i=0;i<len;i++){
            Integer temp = map.get(s.charAt(i));
            if(temp==null){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),temp+1);
            }
        }

        Set set = map.keySet();
        //偶数，肯定行
        //奇数，-1再加上去，如果是1，就加0，没有影响
        //如果出现奇数，最后的结果就能+1了，因为毕竟-1再加
        boolean flag = false;
        int result = 0;
        Iterator<Character> iterator = set.iterator();
        while(iterator.hasNext()){
            int count = map.get(iterator.next());
            if(count%2==0){
                result+=count;
            }else {
                flag=true;
                result+=(count-1);
            }
        }

        if(flag)
            result+=1;

        return result;


    }

}
