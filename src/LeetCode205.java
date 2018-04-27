import java.util.HashMap;
import java.util.HashSet;

public class LeetCode205 {

    public static void main(String[] args) {

        String s = "paper";
        String t = "title";

        System.out.println(isIsomorphic2(s,t));

    }

    public static boolean isIsomorphic2(String s, String t){

        int slen = s.length();
        int tlen = t.length();

        if(slen!=tlen)
            return false;

        if(s.equals(t))
            return true;

        //存对应值
        HashMap<Character,Character> map = new HashMap<>();

        //存是否出现过
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<slen;i++){
            if(map.get(s.charAt(i))==null){
                //防止两个字符对应一个字符，对面的字符必须是没出现过的
                if(set.contains(t.charAt(i)))
                    return false;

                set.add(t.charAt(i));
                map.put(s.charAt(i),t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
        }

        return true;


    }


    /**
     * 大小写是不是敏感？
     * 保留字符的顺序
     * 理解错题目意思了，只需要单向对应过去就可以了，不需要对应回来
     * 比如paper和title e->l r->e
     * 但是两个字符不能对应一个字符
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t){

        int slen = s.length();
        int tlen = t.length();

        if(slen!=tlen)
            return false;

        if(s.equals(t))
            return true;


        HashMap<Character,Character> map = new HashMap<>();

        StringBuilder ss = new StringBuilder(s);
        StringBuilder tt = new StringBuilder(t);

        for(int i=0;i<slen;i++){

            //此时s还没有对应的字符
            //不能通过s找，不然会把t上的都覆盖了
            //比如 ab aa b没有对应的，就把a覆盖了
            //双向找
            if(map.get(s.charAt(i))==null&&map.get(t.charAt(i))==null){
                map.put(s.charAt(i),t.charAt(i));
                //把这个位置修改为s上的字符
                tt.setCharAt(i,s.charAt(i));
            }else if(map.get(s.charAt(i))!=null){
                //s有对应字符了，判断是否和t一样
                if(map.get(s.charAt(i))==t.charAt(i)){
                    //对应的一样，还是得修改，不然最后判断就出错了
                    tt.setCharAt(i,s.charAt(i));
                    continue;
                }else{
                    return false;
                }
            } else{
                //t有对应字符了，判断时候和s一样
                if(map.get(t.charAt(i))==s.charAt(i)){
                    //对应的一样，还是得修改，不然最后判断就出错了
                    tt.setCharAt(i,s.charAt(i));
                    continue;
                }else{
                    return false;
                }

            }

        }

        //以上只能判断出现过的字母一一对应，不能保证顺序

        /**
         * public boolean equals(Object obj) {
         return (this == obj);
         stringbuild的equals是==。只能自己遍历了
         }
         */
        for(int i=0;i<slen;i++){
            if(ss.charAt(i)!=tt.charAt(i))
                return false;
        }

        return true;

    }

}
