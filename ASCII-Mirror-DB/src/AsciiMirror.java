import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AsciiMirror {
    final static Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> fileStrings = new ArrayList<>();
    private final ArrayList<String> fileStringsReversed = new ArrayList<>();

    private int longestStringLength;

    protected String getFilePath() {
        System.out.println("Input the file path:");
        return scanner.nextLine();
    }

    protected int findLongestStringLength(ArrayList<String> fileStrings) {
        int longestStringLength = 0;

        for (String stringLine : fileStrings) {
            if (stringLine.length() > longestStringLength) {
                longestStringLength = stringLine.length();
            }
        }

        return longestStringLength;
    }

    protected void printFile() {
        String currentString;
        for (int i = 0 ; i < getFileStrings().size(); i++) {
            // format fileStrings
            currentString = String.format("%-" + getLongestStringLength() + "s", getFileStrings().get(i));
            System.out.print(currentString);
            System.out.print(" | ");
            currentString = String.format("%" + getLongestStringLength() + "s", getFileStringsReversed().get(i));
            System.out.println(currentString);
        }
    }

    // GETTERS & SETTERS

    protected void setFileStringsReversed(ArrayList<String> fileStrings) {

        ArrayList<String> temporaryReversed = new ArrayList<>();

        for (String stringLine : fileStrings) {
            StringBuilder reversedString = new StringBuilder();
            for (int i = stringLine.length() - 1; i > 0; i--) {
                char currentChar = stringLine.charAt(i);
                if (currentChar == '<') {
                    currentChar = '>';
                } else if (currentChar == '>') {
                    currentChar = '<';
                } else if (currentChar == '[') {
                    currentChar = ']';
                } else if (currentChar == ']') {
                    currentChar = '[';
                } else if (currentChar == '{') {
                    currentChar = '}';
                } else if (currentChar == '}') {
                    currentChar = '{';
                } else if (currentChar == '(') {
                    currentChar = ')';
                } else if (currentChar == ')') {
                    currentChar = '(';
                } else if (currentChar == '/') {
                    currentChar = '\\';
                } else if (currentChar == '\\') {
                    currentChar = '/';
                }
                reversedString.append(currentChar);
            }
            System.out.println(reversedString); // YOU ARE HERE
            temporaryReversed.add(reversedString.toString());
        }

        fileStringsReversed.addAll(temporaryReversed);
    }

    protected ArrayList<String> getFileStringsReversed() {
        return fileStringsReversed;
    }

    protected void setFileStrings(String pathToFile) {
        File file = new File(pathToFile);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                fileStrings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        // find the longest string
        setLongestStringLength(findLongestStringLength(fileStrings));

        // set reversed
        setFileStringsReversed(fileStrings);
    }

    protected ArrayList<String> getFileStrings() {
        return fileStrings;
    }

    public int getLongestStringLength() {
        return longestStringLength;
    }

    public void setLongestStringLength(int longestStringLength) {
        this.longestStringLength = longestStringLength;
    }
}