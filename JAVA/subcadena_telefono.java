import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String input = "23";
        List<String> combinations = generateCombinations(input);
        System.out.println("Combinations for " + input + ": " + combinations);
    }

    public static List<String> generateCombinations(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.length() == 0)
            return result;

        Map<Character, char[]> keypad = new HashMap<>();
        keypad.put('2', new char[]{'A', 'B', 'C'});
        keypad.put('3', new char[]{'D', 'E', 'F'});
        keypad.put('4', new char[]{'G', 'H', 'I'});
        keypad.put('5', new char[]{'J', 'K', 'L'});
        keypad.put('6', new char[]{'M', 'N', 'O'});
        keypad.put('7', new char[]{'P', 'Q', 'R', 'S'});
        keypad.put('8', new char[]{'T', 'U', 'V'});
        keypad.put('9', new char[]{'W', 'X', 'Y', 'Z'});

        generateCombinationsHelper(result, keypad, input, "", 0);
        return result;
    }

    private static void generateCombinationsHelper(List<String> result, Map<Character, char[]> keypad, String input,
      String current, int index) {
        if (index == input.length()) {
            result.add(current);
            return;
        }

        char digit = input.charAt(index);
        if (!keypad.containsKey(digit))
            return;

        char[] letters = keypad.get(digit);
        for (char letter : letters) {
            generateCombinationsHelper(result, keypad, input, current + letter, index + 1);
        }
    }
}
