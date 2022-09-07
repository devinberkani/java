
class Problem {
    public static void main(String[] args) {
        System.out.println(findTest(args));
    }

    public static int findTest(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("test")) {
                return i;
            }
        }
        return -1;
    }
}