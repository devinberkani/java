import java.util.Scanner;

class Util {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String tgt = scanner.nextLine();

        System.out.println(indexOf(src, tgt));
    }

    public static int indexOf(String src, String tgt) {
        if (!src.contains(tgt)) {
            return -1;
        } else if (src.startsWith(tgt)) {
            return 0;
        } else {
            return 1 + indexOf(src.substring(1), tgt);
        }
    }
}
