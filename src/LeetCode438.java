import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        System.out.println(findAnagrams("abab","ab"));

    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        int [] pp = new int[256];

        int pLen = p.length();

        //hash
        for(int i=0;i<pLen;i++){
            pp[p.charAt(i)]++;
        }

        int left = 0;
        int right =0;
        int count = pLen;
        int sLen = s.length();

        while(right<sLen){

            //当前字符属于p，且还没出现过
            //因为无论如何，这个都是要--的
            //也无论如何right都是要++的
            if (pp[s.charAt(right++)]-->0){
                count--;
            }
            //也可以写成这样
//            if(pp[s.charAt(right)]>0){
//                pp[s.charAt(right)]--;
//                right++;
//                count--;
//            }else{
//                pp[s.charAt(right)]--;
//                right++;
//            }

            //如果这次导致count为0了，就是找个一个满足的串了，返回第一个下标
            if (count==0)
                result.add(left);

            //如果这次right-left间隔是plen，就是长度+1，就是说，现在该移动左边了
            //因为无论如何，这个滑动窗口的长度都应该是plen，每次right-left的时候，才移动左边
            //如果移动的时候，左边的字母属于p，才count++
            //因为前面属于p的，会导致减为>=0，如果不属于的，都导致减为负数
            //&&很好的保障了递进的判断
            if (right-left==pLen&&pp[s.charAt(left++)]++>=0){
                count++;
            }


        }

        return result;

    }

}
