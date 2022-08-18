import java.util.Scanner;

public class AsciiMirror {
    final static Scanner scanner = new Scanner(System.in);

    protected void repeatFilePath(String filePath) {
        System.out.println(filePath);
    }
    protected String getFilePath() {
        System.out.println("Input the file path:");
        String filePath = scanner.nextLine();
        repeatFilePath(filePath);
        return filePath;
    }

    protected void printCow() {
        System.out.println("            ^__^\n" +
                "    _______/(oo)\n" +
                "/\\/(       /(__)\n" +
                "   | w----||    \n" +
                "   ||     ||    ");
    }
}
