public class LeetCode13 {

    public int romanToInt(String s) {

        int result = 0;

        for(int i=0,len = s.length();i<len;i++){

            //只有I X C需要看右边而已
            if(s.charAt(i)=='I'){
                if(i==len-1){
                    result+=1;
                }else{
                    if(s.charAt(i+1)=='V'){
                        result+=4;
                        i++;
                    }else if(s.charAt(i+1)=='X'){
                        result+=9;
                        i++;
                    }else{
                        result+=1;
                    }
                }
            }

            else if(s.charAt(i)=='X'){
                if(i==len-1){
                    result+=10;
                }else{
                    if(s.charAt(i+1)=='L'){
                        result+=40;
                        i++;
                    }else if(s.charAt(i+1)=='C'){
                        result+=90;
                        i++;
                    }else{
                        result+=10;
                    }
                }
            }

            else if(s.charAt(i)=='C'){
                if(i==len-1){
                    result+=100;
                }else{
                    if(s.charAt(i+1)=='D'){
                        result+=400;
                        i++;
                    }else if(s.charAt(i+1)=='M'){
                        result+=900;
                        i++;
                    }else{
                        result+=100;
                    }
                }
            }

            else{

                char temp = s.charAt(i);

                switch (temp){
                    case 'V':result+=5;break;
                    case 'L':result+=50;break;
                    case 'D':result+=500;break;
                    case 'M':result+=1000;break;
                }

            }



        }

        return result;

    }

}
