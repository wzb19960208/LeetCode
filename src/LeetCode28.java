public class LeetCode28 {

    public int strStr(String haystack, String needle) {

        //要找的是空，返回0
        if(needle==null)
            return 0;

        //元字符是null，肯定是-1找不到
        if(haystack==null)
            return -1;

        int len1 = haystack.length();
        int len2 = needle.length();


        //要找的比原来的长
        if(len1<len2)
            return -1;

        if(len1==len2){
            if(haystack.equals(needle))
                return 0;
            else
                return -1;
        }

        //到了这个len1肯定比len2大了
        if(len2==0)
            return 0;

        //到了这里，len1和len2都大于0

        int begin = 0;

        while(len1-begin>=len2){

            //假设存在
            boolean exist = true;

            for(int i=begin,j=0;i<len1&&j<len2;i++,j++){
                if(haystack.charAt(i)!=needle.charAt(j)){
                    exist = false;
                    break;
                }
            }

            //正常跳出的话就是找到了
            if(exist)
                return begin;

            begin++;


        }

        return -1;

    }

}
