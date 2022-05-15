public class LargestPrime {
    public static int getLargestPrime(int number){
//Assining a new variable to work on, so we can print out the original number at the end of the method easily.

        int num = number;
        if(num<=1){
            System.out.println("1 or 0 don't contain prime numbers and are not prime numbers");
            return -1;
        }
        //Now we divide the number in a loop. if a remainder of 0 is left than we got a prime divider.
        int i = 2;
        while (i <= num){
            if(num%i == 0){
                num/= i;
                i--;
            }
            i++;
        }
//Printing out the value.

        System.out.println("The Largest prime of " + number + " is " + i);
        return i;
    }
}
