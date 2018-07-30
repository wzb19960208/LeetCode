public class LeetCode67 {

    public String addBinary(String a, String b) {




            //反着存，到最后反转即可
            StringBuilder result = new StringBuilder();

            //不对0，长度不一样，那么是要从各自右边算起，而不是取一个值

            boolean flag = false;

            int i = a.length()-1;
            int j = b.length()-1;

            //先加长度相同的部分
            while(i>=0&&j>=0){

                if(a.charAt(i)=='1'){

                    if(b.charAt(j)=='0'){

                        if(flag){
                            result = result.append('0');
                        }else{
                            result = result.append('1');
                        }

                    }else {
                        if(flag){
                            result = result.append('1');
                        }else{
                            result = result.append('0');
                            flag=true;
                        }
                    }


                }else{

                    if(b.charAt(j)=='0'){

                        if(flag){
                            result =result.append('1');
                            flag=false;
                        }else{
                            result = result.append('0');
                        }


                    }else{

                        if(flag){
                            result =result.append('0');
                        }else{
                            result = result.append('1');
                        }


                    }


                }

                j--;
                i--;
            }

            //出来之后，看看谁还没加完
            if(i<0&&j<0){
                //不用管了，都ok了
            }else if (i>=0){
                //进位好烦
                while(i>=0){
                    if(a.charAt(i)=='1'){
                        if(flag){
                            result = result.append('0');
                        }else{
                            result = result.append('1');
                        }
                    }else{
                        if(flag){
                            result = result.append('1');
                            flag=false;
                        }else{
                            result = result.append('0');
                        }
                    }
                    i--;
                }
            }else{
                while(j>=0){
                    if(b.charAt(j)=='1'){
                        if(flag){
                            result = result.append('0');
                        }else{
                            result = result.append('1');
                        }
                    }else{
                        if(flag){
                            result = result.append('1');
                            flag=false;
                        }else{
                            result = result.append('0');
                        }
                    }
                    j--;
                }

            }

            //最后还有一个进位
            if(flag){
                result = result.append(1);
            }


            return result.reverse().toString();

    }

}
