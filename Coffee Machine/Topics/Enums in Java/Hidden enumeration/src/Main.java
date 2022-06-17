public class Main {

    public static void main(String[] args) {
        int counter = 0;

        // write your code here

        for (Secret secret : Secret.values()) {
            String word = secret.toString();

            char firstLetter = word.charAt(0);
            char secondLetter = word.charAt(1);
            char thirdLetter = word.charAt(2);
            char fourthLetter = word.charAt(3);

            if (firstLetter == 'S' && secondLetter == 'T' && thirdLetter == 'A' && fourthLetter == 'R') {
                counter++;
            }

        }

        System.out.println(counter);
    }
}

//// sample enum for inspiration
//enum Secret {
//    STAR, CRASH, START, // ...
//}