public class MyString {
    /*
    public static void main(String args[]) {
        System.out.println(MyString.subsetOf("sap","space"));
        System.out.println(MyString.subsetOf("spa","space"));
        System.out.println(MyString.subsetOf("pass","space"));
        System.out.println(MyString.subsetOf("c","space"));
        System.out.println("..." + MyString.spacedString("foobar") + "...");
        System.out.println(MyString.randomStringOfLetters(3));
        // Put more tests of your own here.
        System.out.println(countChar("ddd",'d'));
        System.out.println(subsetOf("good job!","good job!"));
        System.out.println(remove("meet","committee"));

    }
    */
     

    /**
     * Returns the number of times the given character appears in the given string.
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        // Replace the following statement with your code.
        if(str == "") return 0;
        int count = 0;
        for ( int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c) {
                count++;
            }
        }
        return count;
    
    }

    /** Returns true if str1 is a subset string str2, false otherwise.
     *  For example, "spa" is a subset of "space", and "pass" is not
     *  a subset of "space".
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        // Replace the following statement with your code.
        if(str1 == null || str2 == null || str2.length() < str1.length()) return false;
        if((remove(str1,str2)).equals("")) return true;
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it. 
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        // Replace the following statement with your code.

        String spaceStr = "";
        if (str.length() == 0) return "";
        for(int i = 0; i < str.length()-1; i++){
            spaceStr += str.charAt(i) +" ";
        }
        spaceStr += str.charAt(str.length()-1);
        return spaceStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        // Replace the following statement with your code.
        //97-122
        if (n<=0)return "not a valid input!";
        String randomsLetters= "";
        for(int i = 0; i < n; i++){
            char c = (char)((int)(Math.random()*26 + 97));
            randomsLetters += c;

        }

        return randomsLetters;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: "committee" minus "meet" returns "comit". 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        // Replace the following statement with your code.
        String removeStr = "";
        for(int i = 0; i <str1.length(); i++){
            char c = str1.charAt(i);
            if(countChar(str2,c) == 0){
                removeStr += c;
            }else{
                String str2Beginning= str2.substring(0,str2.indexOf(c));
                String str2End = str2.substring(str2.indexOf(c)+1);
                str2= str2Beginning + str2End;
            }
        }
        return removeStr;
    }
    
    
}
