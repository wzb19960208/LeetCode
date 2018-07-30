public class LeetCode58 {

    public int lengthOfLastWord(String s) {

        //特殊情况  只有一个单词   只有一个空格  " a"这样竟然也合法！服了

        //"a "这样也行。。。看来根本就没打算输入合法的字符了

        //我猜肯定会有" a "这种，或者"           a                  "

        //别找空格，直接找单词

//        if(s==null)
//            return 0;
//
//        int len = s.length()-1;
//        int index = len;
//
//        //长度是0
//        if(len<0)
//            return 0;
//
//
//        //从后面开始找，找到第一个空格即可
//        while(index>=0){
//            if(s.charAt(index)==' ')
//                break;
//
//            index--;
//        }
//
//        if(index>=0){
//            return len-index;
//        }
//        else {
//            //忘了只有一个单词的情况
//            ////如果小于0才退出，就是整个字符串都是单词
//            return len+1;
//        }


        //先把特殊情况解决了
        if(s==null||s.length()==0)
            return 0;

        int count = 0;
        boolean skipSpace = true;

        //从后面开始，遇到空格就跳过，知道遇到第一个字母，开始计数，再遇到空格就break
        for(int i=s.length()-1;i>=0;i--){

            if(s.charAt(i)==' '){
                if(!skipSpace)
                    break;
            }else{
                //遇到字母了
                count++;
                skipSpace=false;
            }

        }

        return count;


    }

}
