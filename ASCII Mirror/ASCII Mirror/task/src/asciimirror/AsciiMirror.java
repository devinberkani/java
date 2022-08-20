package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AsciiMirror {
    final static Scanner scanner = new Scanner(System.in);
    private final ArrayList<String> fileStrings = new ArrayList<>();

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
        for (String stringLine: getFileStrings()) {
            // format fileStrings
            stringLine = String.format("%-" + getLongestStringLength() + "s", stringLine);
            System.out.print(stringLine);
            System.out.print(" | ");
            System.out.println(stringLine);
        }
    }

    // GETTERS & SETTERS

    protected ArrayList<String> setFileStrings(String pathToFile) {
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

        return fileStrings;
    }

    public ArrayList<String> getFileStrings() {
        return fileStrings;
    }

    public int getLongestStringLength() {
        return longestStringLength;
    }

    public void setLongestStringLength(int longestStringLength) {
        this.longestStringLength = longestStringLength;
    }
}