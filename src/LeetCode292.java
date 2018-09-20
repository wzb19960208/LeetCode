public class LeetCode292 {

    public boolean canWinNim(int n) {

        if(n<=0)
            return false;

        if(n%4!=0)
            return true;
        else
            return false;

    }

}
