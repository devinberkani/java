public class Main {
    public static void main(String[] args) {
        int[] v = {1, 2, 3};

        int p = 3;

        int hashValue = 0;

        for (int i = 0; i < v.length; i++) {
            hashValue = hashValue * p + v[i];
        }

        System.out.println(hashValue);
    }
}