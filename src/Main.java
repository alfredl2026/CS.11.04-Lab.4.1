import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        decipherThis("72olle 103doo 100ya");
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                check++;
            } else if (str.charAt(i) == ')' && check > 0) {
                check--;
            } else if (str.charAt(i) == ')' && check == 0) {
                return false;
            }
        }
        if (check > 0) return false;
        else return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int rev) {
        String newStr = "";
        String ints = String.valueOf(rev);
        for (int i = 0; i < ints.length(); i++) {
            newStr = newStr + ints.substring(ints.length() - i - 1, ints.length() - i);
        }
        return newStr;
    }

    // 3. encryptThis
    public static String encryptThis(String str) {
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i + 1) == ' ') {
                count++;
            }
        }
        System.out.println(count); //check how many words
        String[] words = new String[count];
        for (int i = 0; i < words.length; i++) {
            words[i] = "";
        }
        System.out.println(Arrays.toString(words)); //check words
        String[] temp = new String[count];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = "";
        }
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count2++;
                i++;
            }
            temp[count2] = temp[count2] + str.charAt(i);
        }
        System.out.println(Arrays.toString(temp));//check what temp has
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < temp[i].length(); j++) {
                if (j == 0) {
                    words[i] = words[i] + (int) temp[i].charAt(j);
                } else if (j == 1) words[i] = words[i] + temp[i].charAt(temp[i].length() - 1);
                else if (j == temp[i].length() - 1) words[i] = words[i] + temp[i].charAt(1);
                else {
                    words[i] = words[i] + temp[i].charAt(j);
                }
                System.out.println("loop j " + j + " finished");
                System.out.println(j < temp[i].length());
                System.out.println(temp[i].length());
                System.out.println(temp[i]);
                System.out.println(words[i]); //all this stuff are for debugging
            }
            System.out.println("loop i " + i + " finished");
        }
        System.out.println("done" + Arrays.toString(words)); //check result delete after finish
        String newStr = "";
        for (int i = 0; i < count; i++) {
            newStr = newStr + words[i];
            if (i <= count - 2) newStr = newStr + " ";
        }
        System.out.println(newStr);
        return newStr;
    }

    // 4. decipherThis
    public static String decipherThis(String str) {
        String result = "";
        String[] words = str.split(" ");
        for (String word : words) {
            int length = word.length();
            int first = 0;
            int i = 0;
            while (i < length && Character.isDigit(word.charAt(i))) {
                first = first * 10 + (word.charAt(i) - '0');
                i++;
            }
            char decodedFirst = (char) first;
            String second = "";
            String middle = "";
            if (length - i > 1) {
                second = word.substring(length - 1, length);
                middle = word.substring(i + 1, length - 1);
            }
            char last = word.charAt(i);
            result += decodedFirst + second + middle + last + " ";
        }
        return result.trim();
    }
}