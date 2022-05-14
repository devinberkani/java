package com.example;

public class Main {
    public static void main(String[] args) {
        //write code below
//        int count = 6;
//        while(count != 6) {
//            System.out.println("Count value is " + count);
//            count++;
//        }
//
//        for(int i=6; i!=6; i++) {
//            System.out.println("Count value is " + i);
//        }

//        count = 6;
//        do {
//            System.out.println("Count value was " + count);
//            count++;
//
//            if(count > 100) {
//                break;
//            }
//        } while(count != 6);

//        count = 1;
//        while(true) {
//            if(count == 6) {
//                break;
//            }
//            System.out.println("Count value is " + count);
//            count++;
//        }


//        for(count=1; count != 6; count++) {
//            System.out.println("Count value is " + count);
//        }

        int number = 4;
        int finishNumber = 20;
        int count = 0;
        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            } else {
                count++;
                System.out.println("Even number " + number);
                if (count == 5) {
                    break;
                }
            }
        }
        System.out.println("Total of numbers found is " + count);
    }

    public static boolean isEvenNumber(int n) {
        if (n % 2 == 0) {
            return true;
        }
        return false;
    }
}
