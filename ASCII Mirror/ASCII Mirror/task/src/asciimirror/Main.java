package asciimirror;

public class Main {
    public static void main(String[] args) {
        AsciiMirror asciiMirror = new AsciiMirror();
        String pathToFile = asciiMirror.getFilePath();
        asciiMirror.setFileStrings(pathToFile);
        asciiMirror.printFile();
    }
}