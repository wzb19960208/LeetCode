public class LeetCode400 {

    public int findNthDigit(int n) {

        if(n<=9)
            return n;

        //位数
        int count = 1;

        //一开始只有9个、90、900、9000
        int begin = 9;

        while(true){

            //在第10次，就是10x90亿了，会溢出。肯定不会>=10
            //9之后已经是这道题目的极限，不用再判断第10次了
            if(count==9)
                break;

            if(n>(count*begin)){
                n-=(count*begin);
                count++;
                begin*=10;
            }else{
                break;
            }
        }

        //出来之后，n在该范围之间
        //n如果是中间的数字，会导致少一个
        int temp = (n/count);
        if(n%count>0){
            temp+=1;
        }

        //第一个十位数是9+1 10+1-1
        //第一个百位数是99+1 100+1-1
        //第tmep个是999····9+temp 100····0+temp-1
        //也就是
        int num = (int)Math.pow(10,count-1)+temp-1;

        int index = n%count;
        //0其实是最后一位
        if(index==0)
            return num%10;

        //取这个数的第index位，从左到右的
        return (num/((int)Math.pow(10,count-index)))%10;



    }

}
