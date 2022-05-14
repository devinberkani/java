public class AllFactors {
    public static void printFactors(int n) {
        if (n < 1) {
            System.out.println("Invalid Value");
        }
        int i = 1;
        while(i <= n) {
            if(n % i ==0) {
                System.out.println(i);
            }
            i++;
        }
    }
}
