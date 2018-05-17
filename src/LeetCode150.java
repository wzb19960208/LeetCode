import java.util.LinkedList;

public class LeetCode150 {

    public static void main(String[] args) {

        System.out.println("/");
        String [] tokens = {"-78","-33","196","+","-19","-","115","+","-","-99","/","-18","8","*","-86","-","-","16","/","26","-14","-","-","47","-","101","-","163","*","143","-","0","-","171","+","120","*","-60","+","156","/","173","/","-24","11","+","21","/","*","44","*","180","70","-40","-","*","86","132","-84","+","*","-","38","/","/","21","28","/","+","83","/","-31","156","-","+","28","/","95","-","120","+","8","*","90","-","-94","*","-73","/","-62","/","93","*","196","-","-59","+","187","-","143","/","-79","-89","+","-"};
        System.out.println(evalRPN(tokens));

    }

    public static int evalRPN(String[] tokens) {

        /**
         *
         * 遇到运算符，就将前面的两个数字出栈，计算出结果后，入栈
         *
         */

        LinkedList<String> stack = new LinkedList<>();

        int len = tokens.length;

        for(int i=0;i<len;i++) {

            //千万别用等号来判断
            if (tokens[i].equals("+")|| tokens[i].equals("-")|| tokens[i].equals("*")|| tokens[i].equals("/")) {

                Long num2 = Long.parseLong(stack.pollLast());
                Long num1 = Long.parseLong(stack.pollLast());
                Long temp = 0L;

                if (tokens[i].equals("+")) {
                    temp = num1 + num2;
                } else if (tokens[i].equals("-")) {
                    temp = num1 - num2;
                } else if (tokens[i].equals("*")) {
                    temp = num1 * num2;
                } else if (tokens[i].equals("/")) {
                    temp = num1 / num2;
                }

                stack.addLast(temp.toString());

            }else{

                stack.addLast(tokens[i]);

            }
        }

        return Integer.parseInt(stack.pollLast());

    }

}
