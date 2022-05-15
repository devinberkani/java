public class FlourPackProblem {
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            System.out.println("false");
            return false;
        }
        int i = 0;
        int j = 0;
        while(i <= bigCount) {
            int bigCountTest = 5 * i;
            System.out.println("testing bigCount at " + i);
            if(bigCountTest == goal) {
                System.out.println("true");
                return true;
            }
            while(j <= smallCount) {
                System.out.println("testing smallCount at " + j);
                if(bigCountTest + j == goal) {
                    System.out.println("true");
                    return true;
                }
                j++;
            }
            i++;
            j = 0;
        }
        System.out.println("false");
        return false;
    }
}
