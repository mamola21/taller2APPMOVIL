
import java.util.HashMap;
public class Main {
    public static String main(String args){
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        int maxStart = 0;

        for (int i = 0; i < args.length(); i++) {
            char c = args.charAt(i);
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                start = charIndex.get(c) + 1;
            }
            charIndex.put(c, i);
            int currentLength = i - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }
        }

        // La subcadena máxima es desde maxStart hasta maxStart + maxLength - 1
        return args.substring(maxStart, maxStart + maxLength);
    }

    public static void main(String[] args) {
        String inputString = "abcabcbb";
        System.out.println("Subcadena más larga sin caracteres repetidos: " + main(inputString));
    }
}
