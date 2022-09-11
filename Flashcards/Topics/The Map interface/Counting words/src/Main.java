import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {

        SortedMap<String, Integer> sortedMap = new TreeMap<>();

        for (String currentWord : strings) {
            int count = 0;
            for (String comparisonWord : strings) {
                if (comparisonWord.equals(currentWord)) {
                    count++;
                }
            }
            sortedMap.putIfAbsent(currentWord, count);
            count = 0;
        }

        return sortedMap;
    }

    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}