import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksey Anikeev aka AgentChe
 * Date of creation: 13.08.2022
 */
public class Main {
    static final String text = "Lorem ipsum dolor sit amet," +
            " consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." +
            " Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." +
            " Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur." +
            " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String result = removeSymbols(text);
        quantitySearch(map, result);
        findingMinAndMax(map);
    }

    private static void quantitySearch(Map<Character, Integer> map, String result) {
        for (int i = 0; i < result.length(); i++) {
            char letter = result.charAt(i);
            Integer count = map.get(letter);
            if (map.containsKey(letter)) {
                map.put(letter, count + 1);
            } else {
                map.put(letter, 1);
            }
        }
    }

    public static String removeSymbols(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static void findingMinAndMax(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        char minLetter = 0;
        char maxLetter = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (min > entry.getValue()) {
                min = entry.getValue();
                minLetter = entry.getKey();
            }
            if (max < entry.getValue()) {
                max = entry.getValue();
                maxLetter = entry.getKey();
            }
        }
        System.out.println("Максимально встречался буква " + maxLetter + ", был упомянут " + max + " раз.");
        System.out.println("Минимально встречался буква " + minLetter + ", был упомянут " + min + " раз.");
    }
}
