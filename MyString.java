/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String greeting = "hello";
        System.out.println(countChar(greeting, 'h'));
        System.out.println(countChar(greeting, 'l'));
        System.out.println(countChar(greeting, 'z'));
        System.out.println(spacedString(greeting));
        //// Put your other tests here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countOccurrences("Center",'e') returns 2 and countOccurrences("Center",'c') returns 0.
     *
     * @param inputStr - a string
     * @param targetChar - a character
     * @return the number of times targetChar appears in inputStr
     */
    public static int countChar(String inputStr, char targetChar) {

        int occurrenceCount = 0;
        if (!(inputStr instanceof String) || (inputStr.length() == 0)) {
            return 0;
        }
        for (int i = 0; i < inputStr.length(); i++) {

            if (inputStr.charAt(i) == targetChar) {

                occurrenceCount++;
            }
        }
       
        return occurrenceCount;
    }

    /**
     * Returns true if str1 is a subset string of str2, false otherwise
     * Examples:
     * subsetOf("sap","space") returns true
     * subsetOf("spa","space") returns true
     * subsetOf("pass","space") returns false
     * subsetOf("c","space") returns true
     *
     * @param smallStr - a string
     * @param largeStr - a string
     * @return true if smallStr is a subset of largeStr, false otherwise
     */
    public static boolean subsetOf(String smallStr, String largeStr) {
         
        if (smallStr.length() > largeStr.length()) {
            return false;
        }

        if (smallStr.isEmpty()) return true;

       
        for (int i = 0; i < smallStr.length(); i++) {
            char currentChar = smallStr.charAt(i);
           
            if (!largeStr.contains(Character.toString(currentChar))) {
               
                return false;
            }
   
            largeStr = largeStr.replaceFirst(Character.toString(currentChar), "");
        }
   
        return true;
    }

    /**
     * Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character.
     * Example: insertSpaces("silent") returns "s i l e n t"
     *
     * @param inputStr - a string
     * @return a string consisting of the characters of inputStr, separated by spaces.
     */
    public static String spacedString(String inputStr) {

        String spacedStr = "";
       
        for (int i = 0; i < inputStr.length(); i++) {
           
            spacedStr += inputStr.charAt(i);

            if (i < inputStr.length() - 1) {
                spacedStr += " ";
            }
        }

        return spacedStr;
    }
 
    /**
     * Returns a string of n lowercase letters, selected randomly from
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     *
     * Example: generateRandomLetters(3) can return "zoo"
     *
     * @param length - the number of letters to select
     * @return a randomly generated string, consisting of 'length' lowercase letters
     */
    public static String randomStringOfLetters(int length) {
       
        String randomLetters = "";
       
        for (int i = 0; i < length; i++) {

            int randomCharCode = (int) (Math.random() * (122 - 97 + 1)) + 97;
            char randomLetter = (char) randomCharCode;

            randomLetters += randomLetter;

        }
        return randomLetters;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: removeChars("meet","committee") returns "comit"
     *
     * @param inputStr1 - a string
     * @param inputStr2 - a string
     * @return a string consisting of inputStr1 minus all the characters of inputStr2
     */
    public static String remove(String inputStr1, String inputStr2) {
   
       
        for (int i = 0; i < inputStr2.length(); i++) {
            char currentChar = inputStr2.charAt(i);
           
            if (inputStr1.contains(Character.toString(currentChar))) {

                inputStr1 = inputStr1.replaceFirst(Character.toString(currentChar), "");
               
            }
        }
   
        return inputStr1;
    }

    /**
     * Returns a string consisting of the given string, with the given
     * character inserted randomly somewhere in the string.
     * For example, insertCharRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param randomChar - a character
     * @param inputStr - a string
     * @return a string consisting of inputStr with randomChar inserted somewhere
     */
    public static String insertCharRandomly(char randomChar, String inputStr) {
       
         
         int randomIndex = (int) (Math.random() * (inputStr.length() + 1));
         String resultStr = inputStr.substring(0, randomIndex) + randomChar + inputStr.substring(randomIndex);
         return resultStr;
    }    
}
