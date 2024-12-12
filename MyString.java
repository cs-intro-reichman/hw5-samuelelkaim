/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("spa", "space"));
        System.out.println(subsetOf("pass", "space"));
        System.out.println(remove("committee", "meet"));
        System.out.println(randomStringOfLetters(5));
        System.out.println(insertRandomly('x', "test"));
    }

    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static boolean subsetOf(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (countChar(str2, str1.charAt(i)) < countChar(str1, str1.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String spacedString(String str) {
        StringBuilder spaced = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            spaced.append(str.charAt(i));
            if (i < str.length() - 1) {
                spaced.append(" ");
            }
        }
        return spaced.toString();
    }

    public static String randomStringOfLetters(int n) {
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char randomChar = (char) ('a' + Math.random() * 26);
            randomString.append(randomChar);
        }
        return randomString.toString();
    }

    public static String remove(String str1, String str2) {
        StringBuilder result = new StringBuilder(str1);
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            int index = result.indexOf(String.valueOf(ch));
            if (index != -1) {
                result.deleteCharAt(index);
            }
        }
        return result.toString();
    }

    public static String insertRandomly(char ch, String str) {
        int randomIndex = (int) (Math.random() * (str.length() + 1));
        return str.substring(0, randomIndex) + ch + str.substring(randomIndex);
    }
}

/**
 * Scrabble game implementation.
 */
import java.util.*;

public class Scrabble {

    static final String WORDS_FILE = "dictionary.txt";
    static final int[] SCRABBLE_LETTER_VALUES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
    static int HAND_SIZE = 10;
    static String[] DICTIONARY;
    static int NUM_OF_WORDS;

    public static void init() {
        List<String> dictionaryList = new ArrayList<>();
        Scanner scanner = new Scanner(Scrabble.class.getResourceAsStream(WORDS_FILE));
        while (scanner.hasNext()) {
            dictionaryList.add(scanner.next().toLowerCase());
        }
        DICTIONARY = dictionaryList.toArray(new String[0]);
        NUM_OF_WORDS = DICTIONARY.length;
    }

    public static boolean isWordInDictionary(String word) {
        return Arrays.asList(DICTIONARY).contains(word);
    }

    public static int wordScore(String word) {
        int score = 0;
        for (char c : word.toCharArray()) {
            score += SCRABBLE_LETTER_VALUES[c - 'a'];
        }
        score *= word.length();
        if (word.length() == HAND_SIZE) {
            score += 50;
        }
        if (word.contains("r") && word.contains("u") && word.contains("n") && word.contains("i")) {
            score += 1000;
        }
        return score;
    }

    public static String createHand() {
        StringBuilder hand = new StringBuilder();
        for (int i = 0; i < HAND_SIZE - 2; i++) {
            hand.append((char) ('a' + Math.random() * 26));
        }
        hand.append('a').append('e');
        return MyString.insertRandomly('a', MyString.insertRandomly('e', hand.toString()));
    }

    public static void playHand(String hand) {
        int score = 0;
        Scanner scanner = new Scanner(System.in);
        while (!hand.isEmpty()) {
            System.out.println("Current Hand: " + MyString.spacedString(hand));
            System.out.print("Enter a word, or '.' to finish playing this hand: ");
            String input = scanner.next().toLowerCase();
            if (".".equals(input)) {
                break;
            }
            if (isWordInDictionary(input) && MyString.subsetOf(input, hand)) {
                int wordScore = wordScore(input);
                score += wordScore;
                System.out.println(input + " earned " + wordScore + " points. Score: " + score + " points");
                hand = MyString.remove(hand, input);
            } else {
                System.out.println("Invalid word. Try again.");
            }
        }
        System.out.println("End of hand. Total score: " + score + " points");
    }

    public static void playGame() {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter n to deal a new hand, or e to end the game: ");
            String input = scanner.next().toLowerCase();
            if ("e".equals(input)) {
                break;
            } else if ("n".equals(input)) {
                playHand(createHand());
            } else {
                System.out.println("Invalid input. Please enter 'n' or 'e'.");
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}
