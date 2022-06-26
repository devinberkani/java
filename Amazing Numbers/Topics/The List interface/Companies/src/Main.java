import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> yourList = new ArrayList<>();
        while (scanner.hasNext()) {
            yourList.add(scanner.next());
        }
        System.out.println(yourList);
    }
}