/**
 * PONTIFICIA UNIVERSIDADE CATOLICA DE MINAS GERAIS - PUC MINAS
 * ICEI - CIENCIA DA COMPUTACAO - 2o. periodo
 * DANIELLA EVELLYN JARDIM - 524341
 * Created by dani on 15/02/2018.
 * Palindromo
 */

public class Palindromo {
    /**
     * This function checks if a determined string is a palindrome, returns true if so.
     * @param str the string to check
     * @return either the string is a palindrome or not
     */
    private static boolean isPalindrome(String str){
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     * This functions asserts some words with the respective answers are TRUE;
     * that is, checks if the isPalindrome function is working as expected
     * @return true if tests passes else false
     */
    private static boolean testWhetherItWorks() {

        // this test looks for palindromes in pair/odd number of letters,
        //check both the cases, palindromes and no palindromes. the last two words are to check if they work on
        // numbers (i.e. any kinds of strings)
        String[] words = {"ANA", "PAAP", "NANO", "OOP", "11", "1"};
        boolean[] answers = {true, true, false, false, true, true};

        for (int i = 0 ; i < words.length ; i++) {
            if (isPalindrome(words[i]) != answers[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Iterates over user input until it receives a wildcard (FIM), then it iterates over every input
     * to check whether the input is a palindrome, returning the expected output
     * @param args ignored
     */
    public static void main (String args []){

        if (args.length > 0) {
            if (args[0].equals("-t")) {
                MyIO.println("Running tests");
                // If the program is called with -t argument, it first
                // runs a safety test, to check if the isPalindrome function is correct
                if (testWhetherItWorks()) {
                    MyIO.println("Tests are Ok!");
                } else {
                    throw new RuntimeException("Tests are not working; correct implementation");
                }
            }
            if (args[0].equals("-ij")) {
                MyIO.setCharset("UTF-8");
            }
        }

        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (!entrada[numEntrada++].equals("FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        for(int i = 0; i < numEntrada; i++) {
            if (isPalindrome(entrada[i])) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        }
    }
}
