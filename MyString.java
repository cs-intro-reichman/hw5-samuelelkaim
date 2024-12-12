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
