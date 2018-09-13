import java.util.HashSet;
import java.util.Set;

public class LeetCode389 {
    public static void main(String[] args) {

        char c = 'a';
        System.out.println((int)c);//97

        int [] ss = new int[24];
        System.out.println(ss[1]);//0

        System.out.println(findTheDifference("abcd","abcde"));



    }

    public static char findTheDifference(String s, String t) {

        int [] ss = new int[26];

        int lenS = s.length();
        int lenT = t.length();

        //将s的字符对应的位置++
        for(int i=0;i<lenS;i++){
            ss[(int)s.charAt(i)-97]++;
        }

        char result = ' ';

        //如果t中有相应的字符，那就--进行抵消
        //如果数组变成负数了，这个位置的字符就是多出来的
        for(int i=0;i<lenT;i++){

            int temp = --ss[(int)t.charAt(i)-97];
            if(temp==-1){
                result = t.charAt(i);
                break;
            }

        }

        return result;

    }
}
