public class LeetCode263 {

    public static void main(String[] args) {
        System.out.println(isUgly(50));
    }

    public static boolean isPrime(int n){

        if (n==1||n==2||n==3||n==5)
            return true;

        if(!(n%6==1||n%6==5)){
            return false;
        }

        int temp = (int)Math.sqrt(n);

        //必须是=，不然25，可以55 25
        for(int i=2;i<=temp;i++){
            if (n%i==0)
                return false;
        }

        return true;

    }

    public static boolean isUgly(int num) {

        if(num<=0)
            return false;

        if (num==1||num==2||num==3||num==5)
            return true;

        boolean result = false;

        if(num%2==0){
            //如果是质数，看是不是2、3、5
            int temp = num/2;
          if(isPrime(temp)){
              if(temp==2||temp==3||temp==5){
                  return true;
              }else {
                  return false;
              }
          }else {
              //如果不是质数，那看看这个数是不是丑数
              result = isUgly(num/2);
          }
        }

        if (result){
            return true;
        }else {
            if(num%3==0){
                //如果是质数，看是不是2、3、5
                int temp = num/3;
                if(isPrime(temp)){
                    if(temp==2||temp==3||temp==5){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    result = isUgly(num/3);
                }
            }
        }

        if (result){
            return true;
        }else {
            if(num%5==0){
                //如果是质数，看是不是2、3、5
                int temp = num/5;
                if(isPrime(temp)){
                    if(temp==2||temp==3||temp==5){
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    result = isUgly(num/5);
                }
            }
        }

        return result;


    }

}
