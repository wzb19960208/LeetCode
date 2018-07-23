public class LeetCode38 {

    public static void main(String[] args) {

        System.out.println(countAndSay(5));

    }

    public static String countAndSay(int n) {

        String [] data = new String[n+1];

        data[1] = "1";

        for(int i=2;i<=n;i++){

            //遍历前一个字符串
            String temp = data[i-1];

            char last = temp.charAt(0);
            int count = 1;
            String result = "";

            for(int j=1,len=temp.length();j<len;j++){

                if(temp.charAt(j)==last)
                    count++;
                else{

                    //直接加会加成数字了
                    result+=count;
                    result+=last;

                    //将last设为新数字
                    count=1;
                    last=temp.charAt(j);

                }

            }

            //这样会有问题，如果一直都是同一个数字，就不会触发！=last了
            //要手动把这个数字加上
            result+=count;
            result+=last;

            data[i]=result;

        }

        return data[n];

    }

}
