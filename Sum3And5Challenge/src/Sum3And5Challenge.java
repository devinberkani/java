public class Sum3And5Challenge {
    public static void main(String[] args) {
        int sumTotal = 0;
        int count = 0;
        for(int i=1; i<=1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                sumTotal+= i;
                count++;
                System.out.println("number found: " + i);
                System.out.println("count is at " + count);
                if(count == 5) {
                    System.out.println("task completed");
                    System.out.println("sum of all numbers is " + sumTotal);
                    break;
                }
            }
        }
    }
}
