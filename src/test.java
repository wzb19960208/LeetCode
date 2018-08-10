public class test {

    public static void main(String[] args) {

        String test = "你好？你在吗！123456，abc";

        char [] array = test.toCharArray();

        for(int i=0,len=array.length;i<len;i++){
            System.out.println(array[i]);
        }

    }
}
