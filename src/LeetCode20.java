import java.util.LinkedList;

public class LeetCode20 {

    public static void main(String[] args) {

        String s = "([)]";

        System.out.println(s);

        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        if(s==null){
            return true;
        }

        int len = s.length();

        if(len==0)
            return true;

        LinkedList<Character> stack = new LinkedList<>();

        /**
         *
         * 左括号，入栈
         * 右括号，出栈匹配
         * 这样可以最近匹配，前一个右括号肯定被匹配到了的
         *
         */

        for(int i=0;i<len;i++){

           char temp = s.charAt(i);

            //System.out.println(temp);

           if(temp=='('||temp=='{'||temp=='['){
               stack.addLast(temp);
           }else{

               //如果此时stack里面没有可以匹配的左括号了
               if(stack.size()==0)
                   return false;

               //poll才是弹出
               char left = stack.pollLast();

               //System.out.println(left);

               if(temp=='}'&&left!='{')
                   return false;
               else if(temp==']'&&left!='[')
                   return false;
               else if(temp==')'&&left!='(')
                   return false;

           }

        }

        if(stack.size()==0)
            return true;
        else
            return false;




    }


}
