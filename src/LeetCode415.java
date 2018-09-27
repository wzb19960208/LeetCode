public class LeetCode415 {

    public static void main(String[] args) {
        System.out.println(addStrings("1","9"));
    }

    public static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int len1= num1.length()-1;
        int len2= num2.length()-1;

        //进位
        int count = 0;

        //倒着相加,从后面遍历
        while(0<=len1&&0<=len2){

            char temp1 = num1.charAt(len1);
            char temp2 = num2.charAt(len2);
            int temp = ((int)temp1-48)+((int)temp2-48)+count;
            //用完之后设为0
            count=0;
            if(temp>=10){
                count=1;
                temp%=10;
            }
            sb.append((char)(temp+48));

            len1--;
            len2--;

        }

        while (len1>=0){
            char temp1 = num1.charAt(len1);
            int temp = ((int)temp1-48)+count;
            //用完之后设为0
            count=0;
            if(temp>=10){
                count=1;
                temp%=10;
            }
            sb.append((char)(temp+48));
            len1--;
        }

        while (len2>=0){
            char temp2 = num2.charAt(len2);
            int temp = ((int)temp2-48)+count;
            //用完之后设为0
            count=0;
            if(temp>=10){
                count=1;
                temp%=10;
            }
            sb.append((char)(temp+48));
            len2--;
        }

        //有可能最后还有一个进位呢？
        if(count==1)
            sb.append('1');

        String result = sb.reverse().toString();

        return result;

    }

}
