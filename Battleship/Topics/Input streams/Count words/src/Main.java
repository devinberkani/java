import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readString = reader.readLine().trim();
        reader.close();

        if (readString.isEmpty()) {
            System.out.println(0);
        } else {
            String[] readStringArr = readString.split("\\s+");
            System.out.println(readStringArr.length);
        }
    }
}