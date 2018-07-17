public class LeetCode14 {

    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;

        if(len==0)
            return "";

        //[""],这种情况是有一个元素，切这个元素是“”
        if(strs[0].length()==0)
            return "";

        char current = strs[0].charAt(0);

        int index = 0;

        StringBuilder sb = new StringBuilder();

        while (true) {

            for(int i=0;i<len;i++){
                //有不等的，或者比该字符串长了
                //这个条件应该写在前面，不然先判断charAt可能会溢出
                if(index>=strs[i].length()||strs[i].charAt(index)!=current)
                    return sb.toString();
            }

            //都通过的情况下，可以加上该char
            sb=sb.append(current);

            //更新index
            index++;
            //如果第一个还符合的话，就取下一个
            if(strs[0].length()==index)
                return sb.toString();
            else{
                //更新当前要比较的字符
                current=strs[0].charAt(index);
            }



        }




    }

}
