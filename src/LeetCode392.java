public class LeetCode392 {

    public boolean isSubsequence(String s, String t) {

        int indexS = 0;
        int indexT = 0;

        int sLen = s.length();
        int tLen = t.length();

        while(indexS<sLen&&indexT<tLen){

            if(s.charAt(indexS)==t.charAt(indexT)){
                indexS++;
                indexT++;
            }else{
                indexT++;
            }

        }

        if(indexS==sLen)
            return true;
        else
            return false;

    }

}
